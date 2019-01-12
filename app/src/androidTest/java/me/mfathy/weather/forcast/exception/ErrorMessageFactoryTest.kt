package me.mfathy.weather.forcast.exception

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import me.mfathy.weather.forcast.R
import me.mfathy.weather.forcast.data.store.exceptions.NetworkConnectionException
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mohammed Fathy on 13/01/2019.
 * dev.mfathy@gmail.com
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ErrorMessageFactoryTest {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testNetworkConnectionErrorMessage() {
        val expectedMessage = context.resources.getString(R.string.exception_message_no_connection)
        val actualMessage = ErrorMessageFactory.create(context, NetworkConnectionException())

        assertEquals(actualMessage, expectedMessage)
    }

}