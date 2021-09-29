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

import com.huawei.hms.scene.common.base.ar.FaceLandmark;
import com.huawei.hms.scene.math.Quaternion;
import com.huawei.hms.scene.math.Vector3;

/**
 * Asset Feature
 *
 * @author HUAWEI
 * @since 2021-08-18
 */
public class AssetFeature {
    private String assetPath;
    private FaceLandmark faceLandmark;
    private Vector3 offsetPosition;
    private Vector3 initialScale;
    private Quaternion offsetRotation;

    AssetFeature(String assetPath, FaceLandmark faceLandmark) {
        this.assetPath = assetPath;
        this.faceLandmark = faceLandmark;
    }

    /**
     * set Offset Position
     *
     * @param offsetPosition offset position
     * @return assetFeature
     */
    AssetFeature setOffsetPosition(Vector3 offsetPosition) {
        this.offsetPosition = offsetPosition;
        return this;
    }

    /**
     * set Initial Scale
     *
     * @param initialScale initial scale
     * @return assetFeature
     */
    AssetFeature setInitialScale(Vector3 initialScale) {
        this.initialScale = initialScale;
        return this;
    }

    /**
     * set Offset Rotation
     *
     * @param offsetRotation offset rotation
     * @return assetFeature
     */
    AssetFeature setOffsetRotation(Quaternion offsetRotation) {
        this.offsetRotation = offsetRotation;
        return this;
    }

    /**
     * get Offset Position
     *
     * @return offset of position
     */
    Vector3 getOffsetPosition() {
        return offsetPosition;
    }

    /**
     * get Initial Scale
     *
     * @return the initial scale
     */
    Vector3 getInitialScale() {
        return initialScale;
    }

    /**
     * get Offset Rotation
     *
     * @return the offset of rotation
     */
    Quaternion getOffsetRotation() {
        return offsetRotation;
    }

    /**
     * get Asset Path
     *
     * @return the path of asset
     */
    String getAssetPath() {
        return assetPath;
    }

    /**
     * getFaceLandmark
     *
     * @return the face landmark
     */
    FaceLandmark getFaceLandmark() {
        return faceLandmark;
    }
}
