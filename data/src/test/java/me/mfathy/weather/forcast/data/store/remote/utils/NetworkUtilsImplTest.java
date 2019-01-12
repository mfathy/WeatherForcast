package me.mfathy.weather.forcast.data.store.remote.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(JUnit4.class)
public class NetworkUtilsImplTest {
    private final Context context = (Context) Mockito.mock(Context.class);
    private final ConnectivityManager connManager = (ConnectivityManager) Mockito.mock(ConnectivityManager.class);
    private final NetworkInfo networkInfo = (NetworkInfo) Mockito.mock(NetworkInfo.class);
    private final PackageManager packageManager = (PackageManager) Mockito.mock(PackageManager.class);
    private NetworkUtilsImpl utils = new NetworkUtilsImpl(context);

    @Test
    public final void testHasConnectionReturnTrue() {
        this.stubHasConnection();
        Assert.assertFalse(this.utils.hasConnection());
    }

    private void stubHasConnection() {
        given(context.getPackageManager()).willReturn(packageManager);
        given(context.getSystemService(anyString())).willReturn(connManager);
        given(connManager.getActiveNetworkInfo()).willReturn(networkInfo);
        given(networkInfo.isConnected()).willReturn(true);

    }


}