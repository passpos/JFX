/*
 * Copyright (C) 2020 realpai <paiap@outlook.com>
 *
 * cBox program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * cBox program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with cBox program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jfx.app;

import java.util.ArrayList;
import jfx.scene.*;
import jfx.scene.canvas.*;
import jfx.scene.effect.*;
import jfx.scene.effect.blur.*;
import jfx.scene.effect.shadow.*;
import jfx.scene.image.*;
import jfx.scene.input.*;
import jfx.scene.layout.pane.*;
import jfx.scene.paint.*;
import jfx.scene.paint.material.*;
import jfx.scene.shape.*;
import jfx.scene.shape.curve.CubicCurveApp;
import jfx.scene.shape.curve.QuadCurveApp;
import jfx.scene.shape.d3d.*;
import jfx.scene.shape.line.*;
import jfx.scene.shape.path.PathApp;
import jfx.scene.shape.path.SVGPathApp;
import jfx.scene.text.*;
import jfx.scene.transform.*;
import jfx.core.app.AbstractAppBox;
import jfx.core.app.AbstractSideBox;
import jfx.core.app.ContentBox;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class AppBox extends AbstractAppBox {

    public AppBox(AbstractSideBox sideBox) {
        super(sideBox);
    }

    /**
     * 在此处，将应用添加到应用集
     * step-7
     */
    @Override
    public void initAppList() {        // 7
        ArrayList<Class<? extends ContentBox>> appList = getAppList();

        // Scene
        appList.add(SceneApp.class);
        appList.add(SubSceneApp.class);
        appList.add(NodeApp.class);
        appList.add(CursorApp.class);
        appList.add(GroupApp.class);
        appList.add(PerspectiveCameraApp.class);
        appList.add(AmbientLightApp.class);
        appList.add(PointLightApp.class);

        // Canvas
        appList.add(CanvasApp.class);

        // Effect
        appList.add(BloomAndGlowApp.class);
        appList.add(ReflectionApp.class);
        appList.add(SepiaToneApp.class);
        appList.add(ColorInputApp.class);
        appList.add(ColorAdjustApp.class);
        appList.add(DisplacementMapApp.class);
        appList.add(ImageInputApp.class);
        appList.add(PerspectiveTransformApp.class);
        appList.add(BlendApp.class);
        appList.add(LightingApp.class);

        // Effect - Shadow
        appList.add(ShadowApp.class);
        appList.add(DropShadowApp.class);
        appList.add(InnerShadowApp.class);

        // Effect - Blur
        appList.add(BoxBlurApp.class);
        appList.add(GaussianBlurApp.class);
        appList.add(MotionBlurApp.class);

        // Geometry
        // Image
        appList.add(ImageApp.class);
        appList.add(ImageViewApp.class);
        appList.add(PixelReaderApp.class);
        appList.add(PixelWriterApp.class);
        appList.add(PixelFormatApp.class);
        appList.add(WritablePixelFormatApp.class);
        appList.add(WritableImageApp.class);

        // Input
        appList.add(ClipboardApp.class);
        appList.add(DragboardApp.class);
        appList.add(DemoShortcutApp.class);

        // Layout
        appList.add(AnchorPaneApp.class);
        appList.add(BorderPaneApp.class);
        appList.add(GridPaneApp.class);
        appList.add(TilePaneApp.class);

        // Paint
        appList.add(PaintAndColorApp.class);
        appList.add(LinearGradientApp.class);
        appList.add(ImagePatternApp.class);
        appList.add(RadialGradientApp.class);

        // Paint - Material
        appList.add(PhongMaterialApp.class);

        // Shape
        appList.add(ShapeApp.class);
        appList.add(RectangleApp.class);
        appList.add(CircleApp.class);
        appList.add(EllipseApp.class);
        appList.add(ArcApp.class);
        appList.add(PolygonApp.class);

        // Shape - Line
        appList.add(LineApp.class);
        appList.add(PolylineApp.class);

        // Shape - Curve
        appList.add(QuadCurveApp.class);
        appList.add(CubicCurveApp.class);

        // Shape - Path
        appList.add(PathApp.class);
        appList.add(SVGPathApp.class);

        // Shape - 3D
        appList.add(CoordinateSpaceApp.class);
        appList.add(BoxApp.class);
        appList.add(CylinderApp.class);
        appList.add(SphereApp.class);
        appList.add(MeshViewApp.class);

        // Text
        appList.add(TextApp.class);
        appList.add(FontApp.class);

        // Transform
        appList.add(TranslateApp.class);
        appList.add(ScaleApp.class);
        appList.add(RotateApp.class);
        appList.add(ShearApp.class);
        appList.add(AffineApp.class);

    }
}
