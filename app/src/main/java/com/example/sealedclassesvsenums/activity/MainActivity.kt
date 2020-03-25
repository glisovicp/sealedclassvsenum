package com.example.sealedclassesvsenums.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sealedclassesvsenums.R
import com.example.sealedclassesvsenums.adapter.ServerDropDownAdapter
import com.example.sealedclassesvsenums.util.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val TAG = MainActivity::class.java.simpleName

    private var selectedServerSealed: ServerEnvSealed = Production()
    private var serversSealed: ArrayList<ServerEnvSealed>? = null

    private var adapter: ServerDropDownAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serversSealed = ServerEnvSealed.servers()
        adapter = ServerDropDownAdapter(this, serversSealed!!)
        spinnerServerUrlSealed.adapter = adapter
        spinnerServerUrlSealed.onItemSelectedListener = this

        tvAppVersion.text = getString(R.string.app_version_label, AppUtils.getApplicationVersion())

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d(TAG, "Nothing selected!")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedServerSealed = serversSealed?.get(position) as ServerEnvSealed
        Toast.makeText(this, "It is choosen: ${selectedServerSealed.name}", Toast.LENGTH_LONG).show()
    }


}
