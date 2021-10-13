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
import android.widget.Toast;

import com.huawei.hms.scene.math.Vector3;
import com.huawei.hms.scene.sdk.render.Animator;
import com.huawei.hms.scene.sdk.render.Light;
import com.huawei.hms.scene.sdk.render.Model;
import com.huawei.hms.scene.sdk.render.Node;
import com.huawei.hms.scene.sdk.render.Renderable;
import com.huawei.hms.scene.sdk.render.Resource;
import com.huawei.hms.scene.sdk.render.Transform;
import com.huawei.hms.scene.sdk.ux.ar.ARNode;
import com.huawei.hms.scene.sdk.ux.ar.ARView;

/**
 * ARViewActivity
 *
 * @author HUAWEI
 * @since 2021-08-18
 */
public class ARViewActivity extends Activity {
    private ARView arView;
    private Model testModel;
    private Node node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arview);

        arView = findViewById(R.id.arview);
        // default true
        arView.enablePlaneDisplay(true);
        loadAsset();
        addCameraAndLight();
        arView.addOnTapPlaneEventListener(tapPlaneResult -> {
            node = arView.getScene().createNodeFromModel(testModel);
            node.getComponent(Transform.descriptor())
                .scale(new Vector3(0.01f, 0.01f, 0.01f));
            node.traverseDescendants(des -> {
                Renderable renderableComponent = des.getComponent(Renderable.descriptor());
                if (renderableComponent != null) {
                    renderableComponent.setCastShadow(true).setReceiveShadow(true);
                }
            });
            Animator animator = node.getComponent(Animator.descriptor());
            if (animator != null) {
                animator.play(animator.getAnimations().get(0));
            }
            ARNode arNode = tapPlaneResult.createARNode(node);
            arView.recordARNode(arNode);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        arView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        arView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arView.destroy();
    }

    private void addCameraAndLight() {
        Node lightNode = arView.getScene().createNode();
        lightNode.addComponent(Light.descriptor())
            .setType(Light.Type.DIRECTIONAL)
            .setIntensity(30.f);
    }

    private void loadAsset() {
        if (testModel != null) {
            return;
        }
        Model.builder()
            .setUri(Uri.parse("Robot/scene.gltf"))
            .load(getApplicationContext(), new Resource.OnLoadEventListener<Model>() {
                @Override
                public void onLoaded(Model model) {
                    Toast.makeText(ARViewActivity.this, "load success.", Toast.LENGTH_SHORT).show();
                    testModel = model;
                }

                @Override
                public void onException(Exception exception) {
                    Toast.makeText(ARViewActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }
}
