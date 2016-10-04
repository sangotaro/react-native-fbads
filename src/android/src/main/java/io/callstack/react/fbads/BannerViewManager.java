package io.callstack.react.fbads;


import android.support.annotation.Nullable;

import com.facebook.ads.AdSize;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class BannerViewManager extends SimpleViewManager<BannerView> {

  public BannerViewManager(ReactContext context) {
    super();
  }

  @ReactProp(name = "placementId")
  public void setPlacementId(BannerView view, String placementId) {
    view.setPlacementId(placementId);
  }

  @ReactProp(name = "size")
  public void setSize(BannerView view, ReadableMap size) {
    view.setSize(AdSize.fromWidthAndHeight(size.getInt("width"), size.getInt("height")));
  }

  @Override
  protected BannerView createViewInstance(ThemedReactContext reactContext) {
    return new BannerView(reactContext);
  }

  @Override
  public @Nullable Map getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of(
      "onAdClick",
      MapBuilder.of("registrationName", "onAdClick"),
      "onAdError",
      MapBuilder.of("registrationName", "onAdError")
    );
  }

  @Override
  public String getName() {
    return "CTKBannerView";
  }
}
