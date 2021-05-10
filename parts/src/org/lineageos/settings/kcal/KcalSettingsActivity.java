package org.lineageos.settings.kcal;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.lineageos.settings.Controller;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class KcalSettingsActivity extends CollapsingToolbarBaseActivity  implements Controller {
    private KcalSettings mKcalSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mKcalSettingsFragment = new KcalSettings();
        getFragmentManager().beginTransaction()
                .add(R.id.content_frame, mKcalSettingsFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_reset:
                mKcalSettingsFragment.applyValues(RED_DEFAULT + " " +
                        GREEN_DEFAULT + " " +
                        BLUE_DEFAULT + " " +
                        MINIMUM_DEFAULT + " " +
                        SATURATION_DEFAULT + " " +
                        VALUE_DEFAULT + " " +
                        CONTRAST_DEFAULT + " " +
                        HUE_DEFAULT);
                mKcalSettingsFragment.setmGrayscale(GRAYSCALE_DEFAULT);
                mKcalSettingsFragment.setmSetOnBoot(SETONBOOT_DEFAULT);
                return true;

            case R.id.action_preset:
                new PresetDialog().show(getFragmentManager(),
                        KcalSettingsActivity.class.getName(), mKcalSettingsFragment);
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_reset, menu);
        return true;
    }
}
