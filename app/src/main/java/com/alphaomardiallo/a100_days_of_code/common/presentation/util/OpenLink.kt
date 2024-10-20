package com.alphaomardiallo.a100_days_of_code.common.presentation.util

import android.content.Context
import android.content.Intent
import android.net.Uri


fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
