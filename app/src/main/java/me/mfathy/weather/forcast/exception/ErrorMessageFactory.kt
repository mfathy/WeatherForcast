package me.mfathy.weather.forcast.exception

import android.content.Context
import me.mfathy.weather.forcast.R
import me.mfathy.weather.forcast.data.store.exceptions.NetworkConnectionException

/**
 * Created by Mohammed Fathy on 31/08/2018.
 * dev.mfathy@gmail.com
 *
 * Factory used to create error messages from an Exception as a condition.
 */
object ErrorMessageFactory {

    /**
     * Creates a String representing an error message.
     *
     * @param context Android context.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return [String] an error message.
     */
    fun create(context: Context, exception: Throwable): String {
        var message = context.resources.getString(R.string.exception_message_generic)

        when (exception) {
            is NetworkConnectionException -> message =
                    context.resources.getString(R.string.exception_message_no_connection)
        }

        return message
    }
}