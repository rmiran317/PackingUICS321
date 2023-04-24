package com.example.packingui;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Size;
import android.view.OrientationEventListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;
import java.util.concurrent.ExecutionException;

//need to work on still, migth be unneceessary or whateva, but is tough

public class CameraAnalyzer extends AppCompatActivity implements ImageAnalysis.Analyzer {
    private PreviewView previewView;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private TextView textView;

    static String longWay;

    static boolean success = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        previewView = findViewById(R.id.previewView);
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        textView = findViewById(R.id.orientation);
        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                    bindImageAnalysis(cameraProvider);

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, ContextCompat.getMainExecutor(this));

    }

    private void bindImageAnalysis(@NonNull ProcessCameraProvider cameraProvider) {
        ImageAnalysis imageAnalysis =
                new ImageAnalysis.Builder().setTargetResolution(new Size(1920, 1080))
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST).build();
        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(@NonNull ImageProxy image) {
                @SuppressLint("UnsafeOptInUsageError") Image mediaImage = image.getImage();
                if (mediaImage != null){
                    InputImage finaleImage = InputImage.fromMediaImage(mediaImage, image.getImageInfo().getRotationDegrees());
                    boolean resultIs = scanBarcodes(finaleImage);
                    if (resultIs){
                        Intent intent = new Intent(getApplicationContext(), LabelScanned.class);
                        startActivityForResult(intent, 20);
                        System.out.println("how many of you are there?");
                        onActivityResult(20,20, intent);
                        success = false;
                    }
                }
                mediaImage.close();
                image.close();
            }
        });
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int orientation) {
                textView.setText(Integer.toString(orientation));
            }
        };
        orientationEventListener.enable();
        Preview preview = new Preview.Builder().build();
        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK).build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider()); //previewView method is wonky, might not work
        cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector,
                imageAnalysis, preview);
    }

//    ImageAnalysis imageAnalysis =
//            new ImageAnalysis.Builder()
//                    // enable the following line if RGBA output is needed.
//                    //.setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
//                    .setTargetResolution(new Size(1280, 720))
//                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                    .build();
//
//    imageAnalysis.setAnalyzer(executor, new ImageAnalysis.Analyzer()
//
//    {
//        @Override
//        public void analyze (@NonNull ImageProxy imageProxy){
//        int rotationDegrees = imageProxy.getImageInfo().getRotationDegrees();
//
//        imageProxy.close();
//    }
//    });

    @Override
    public void analyze(@NonNull ImageProxy image) {
        scanBarcodes((InputImage) image);
        image.close();
    }


    public void onActivityResult(int d, int j, Intent data) {
        super.onActivityResult(d, j, data);
        //onResume();
    }

    @Nullable
    @Override
    public Size getDefaultTargetResolution() {
        return ImageAnalysis.Analyzer.super.getDefaultTargetResolution();
    }

    @Override
    public int getTargetCoordinateSystem() {
        return ImageAnalysis.Analyzer.super.getTargetCoordinateSystem();
    }

    @Override
    public void updateTransform(@Nullable Matrix matrix) {
        ImageAnalysis.Analyzer.super.updateTransform(matrix);
    }

    private boolean scanBarcodes(InputImage image) {
        // [START set_detector_options]

        if (image == null) System.out.println("garbage\n\n");

        BarcodeScannerOptions options =
                new BarcodeScannerOptions.Builder()
                        .setBarcodeFormats(
                                Barcode.FORMAT_DATA_MATRIX)
                        .build();
        // [END set_detector_options]

        // [START get_detector]
        //BarcodeScanner scanner = BarcodeScanning.getClient();
        // Or, to specify the formats to recognize:
        BarcodeScanner scanner = BarcodeScanning.getClient(options);
        // [END get_detector]

        // [START run_detector]
        Task<List<Barcode>> result = scanner.process(image)
                .addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {

                    @Override
                    public void onSuccess(List<Barcode> barcodes) {
                        // Task completed successfully
                        // [START_EXCLUDE]
                        // [START get_barcodes]
                        for (Barcode barcode : barcodes) {
                            Rect bounds = barcode.getBoundingBox();
                            Point[] corners = barcode.getCornerPoints();

                            String rawValue = barcode.getRawValue();

                            int valueType = barcode.getValueType();
                            // See API reference for complete list of supported types
                            switch (valueType) {
                                case Barcode.TYPE_TEXT:
                                    longWay = barcode.getRawValue();
                                    success = true;
                                    //String password = barcode.getWifi().getPassword();
                                    break;
                            }
                        }

                        // [END get_barcodes]
                        // [END_EXCLUDE]
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        success = false;

                        // Task failed with an exception
                        // ...
                    }
                });


        System.out.println(success);
        if (success == true){
            return true;
        }
        return false;
    }
}
