package com.example.sealedclassesvsenums.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sealedclassesvsenums.Production
import com.example.sealedclassesvsenums.R
import com.example.sealedclassesvsenums.ServerEnvEnum
import com.example.sealedclassesvsenums.ServerEnvSealed
import com.example.sealedclassesvsenums.adapter.ServerDropDownAdapterEnum
import com.example.sealedclassesvsenums.adapter.ServerDropDownAdapterSealed
import com.example.sealedclassesvsenums.util.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val tag = MainActivity::class.java.simpleName

    private var selectedServerSealed: ServerEnvSealed = Production()
    private var serversSealed = ServerEnvSealed.servers()
    private var adapterSealed: ServerDropDownAdapterSealed? = null

    private var selectedServerEnum: ServerEnvEnum = ServerEnvEnum.Production
    private var serversEnum = arrayListOf(ServerEnvEnum.Development, ServerEnvEnum.QA, ServerEnvEnum.Acceptance, ServerEnvEnum.Production)
    private var adapterEnum: ServerDropDownAdapterEnum? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAppVersion.text = getString(R.string.app_version_label, AppUtils.getApplicationVersion())

        adapterSealed = ServerDropDownAdapterSealed(this, serversSealed)
        spinnerServerUrlSealed.adapter = adapterSealed
        spinnerServerUrlSealed.onItemSelectedListener = this

        adapterEnum = ServerDropDownAdapterEnum(this, serversEnum)
        spinnerServerUrlEnum.adapter = adapterEnum
        spinnerServerUrlEnum.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d(tag, "Nothing selected!")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedServerSealed = serversSealed[position]
        selectedServerEnum = serversEnum[position]
        var message = ""
        when(parent?.tag) {
            "sealed" -> message = "Chosen sealed class is : ${selectedServerSealed.name} and url is ${selectedServerSealed.url}"
            "enum" -> message = "Chosen enum is : ${selectedServerEnum.name} and url is ${selectedServerEnum.url}"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
