package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private ComponentName mActivity;
    private Context mContext;
    private CharSequence mDisabledMessage;
    private IconCompat mIcon;
    private String mId;
    private Intent[] mIntents;
    private CharSequence mLabel;
    private CharSequence mLongLabel;

    private ShortcutInfoCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            builder.setIcon(iconCompat.toIcon());
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            builder.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            builder.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            builder.setActivity(componentName);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent addToIntent(Intent outIntent) {
        outIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            iconCompat.addToShortcutIntent(outIntent);
        }
        return outIntent;
    }

    public String getId() {
        return this.mId;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public Intent getIntent() {
        return this.mIntents[r0.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private final ShortcutInfoCompat mInfo;

        public Builder(Context context, String id) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            this.mInfo.mId = id;
        }

        public Builder setShortLabel(CharSequence shortLabel) {
            this.mInfo.mLabel = shortLabel;
            return this;
        }

        public Builder setLongLabel(CharSequence longLabel) {
            this.mInfo.mLongLabel = longLabel;
            return this;
        }

        public Builder setDisabledMessage(CharSequence disabledMessage) {
            this.mInfo.mDisabledMessage = disabledMessage;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intents) {
            this.mInfo.mIntents = intents;
            return this;
        }

        public Builder setIcon(Bitmap icon) {
            return setIcon(IconCompat.createWithBitmap(icon));
        }

        public Builder setIcon(int icon) {
            return setIcon(IconCompat.createWithResource(this.mInfo.mContext, icon));
        }

        public Builder setIcon(IconCompat icon) {
            this.mInfo.mIcon = icon;
            return this;
        }

        public Builder setActivity(ComponentName activity) {
            this.mInfo.mActivity = activity;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (!TextUtils.isEmpty(this.mInfo.mLabel)) {
                if (this.mInfo.mIntents == null || this.mInfo.mIntents.length == 0) {
                    throw new IllegalArgumentException("Shortcut much have an intent");
                }
                return this.mInfo;
            }
            throw new IllegalArgumentException("Shortcut much have a non-empty label");
        }
    }
}
