/*
 * Copyright 2021 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.hms.scene.demo.ux;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.scene.common.base.ar.FaceLandmark;
import com.huawei.hms.scene.math.Quaternion;
import com.huawei.hms.scene.math.Vector3;
import com.huawei.hms.scene.sdk.render.Model;
import com.huawei.hms.scene.sdk.render.Node;
import com.huawei.hms.scene.sdk.render.Resource;
import com.huawei.hms.scene.sdk.render.Texture;
import com.huawei.hms.scene.sdk.ux.ar.ARFaceNode;
import com.huawei.hms.scene.sdk.ux.ar.FaceView;

/**
 * FaceViewActivity
 *
 * @author HUAWEI
 * @since 2021-08-18
 */
public class FaceViewActivity extends Activity {
    private static final String TAG = "MLFaceViewActivity";
    private FaceView faceView;
    private Model faceModel;
    private Node faceNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection);
        faceView = findViewById(R.id.container1);
        setupIBL();
        // method1: create a new function for each asset, and declare the scale and offset of asset.
        // method2: Bind the material path to the landmark point through AssetFeature,
        // and abstract one loadAsset method.
        AssetFeature beaverAsset = new AssetFeature("Fox/fox.glb", FaceLandmark.TIP_OF_NOSE);
        beaverAsset
            .setOffsetPosition(new Vector3(0.0f, -0.1f, 0.0f))
            .setInitialScale(new Vector3(0.01f, 0.01f, 0.01f))
            .setOffsetRotation(new Quaternion(new Vector3(1.0f, 0.0f, 0.0f), 0));
        loadAsset(beaverAsset);
    }

    private void loadAsset(AssetFeature assetFeature) {
        Model.builder()
            .setUri(Uri.parse(assetFeature.getAssetPath()))
            .load(getApplicationContext(), new Resource.OnLoadEventListener<Model>() {
                @Override
                public void onLoaded(Model model) {
                    if (model == null) {
                        return;
                    }
                    faceModel = model;
                    if (faceModel == null) {
                        return;
                    }
                    faceNode = faceView.getScene().createNodeFromModel(faceModel);
                    if (faceNode == null) {
                        return;
                    }
                    ARFaceNode arFaceNode = faceView.createARFaceNode(faceNode, assetFeature.getFaceLandmark());
                    arFaceNode.setOffsetPosition(assetFeature.getOffsetPosition())
                        .setInitialScale(assetFeature.getInitialScale())
                        .setOffsetRotation(assetFeature.getOffsetRotation());
                }

                @Override
                public void onException(Exception exception) {
                    Log.e(TAG, "onException: load model exception: " + exception.getMessage());
                }
            });
    }

    // method1 example： loadFoxAsset("model/Fox/fox.glb");
    private void loadFoxAsset(String uriPath) {
        Model.builder()
            .setUri(Uri.parse(uriPath))
            .load(getApplicationContext(), new Resource.OnLoadEventListener<Model>() {
                @Override
                public void onLoaded(Model model) {
                    if (model == null) {
                        return;
                    }
                    faceModel = model;
                    if (faceModel == null) {
                        return;
                    }
                    faceNode = faceView.getScene().createNodeFromModel(faceModel);
                    if (faceNode == null) {
                        return;
                    }
                    ARFaceNode arFaceNode = faceView.createARFaceNode(faceNode, FaceLandmark.TIP_OF_NOSE);
                    arFaceNode.setOffsetPosition(new Vector3(0.0f, 0.0f, 0.0f))
                        .setInitialScale(new Vector3(1.0f, 1.0f, 1.0f))
                        .setOffsetRotation(new Quaternion(new Vector3(1.0f, 0.0f, 0.0f), 0));
                }

                @Override
                public void onException(Exception exception) {
                    Log.e(TAG, "onException: load model exception: " + exception.getMessage());
                }
            });
    }

    private void setupIBL() {
        Texture.builder()
            .setUri(Uri.parse("output_specular.dds"))
            .load(getApplicationContext(), new Resource.OnLoadEventListener<Texture>() {
                @Override
                public void onLoaded(Texture texture) {
                    faceView.getScene().setSpecularEnvTexture(texture);
                }

                @Override
                public void onException(Exception exception) {
                    Log.e(TAG, "onException: load specular IBL exception: " + exception.getMessage());
                }
            });

        Texture.builder()
            .setUri(Uri.parse("output_diffuse.dds"))
            .load(getApplicationContext(), new Resource.OnLoadEventListener<Texture>() {
                @Override
                public void onLoaded(Texture texture) {
                    faceView.getScene().setDiffuseEnvTexture(texture);
                }

                @Override
                public void onException(Exception exception) {
                    Log.e(TAG, "onException: load diffuse IBL exception: " + exception.getMessage());
                }
            });
    }

    @Override
    protected void onResume() {
        super.onResume();
        faceView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        faceView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        faceView.destroy();
    }
}