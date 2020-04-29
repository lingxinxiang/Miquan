package com.example.miquan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vi.openapi.VioSerial;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShipping;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodetail);
        mBtnShipping = findViewById(R.id.btn_shipping);
        int ipen = VioSerial.instance().open(VioSerial.SERIAL_101, "/dev/ttyS4");
        if (ipen == 0) {
            Toast.makeText(PaymentActivity.this, "串口打开成功", Toast.LENGTH_SHORT).show();
        }
        if (ipen == -1) {
            Toast.makeText(PaymentActivity.this, "无法打开串口：没有串口读/写权限！", Toast.LENGTH_SHORT).show();
        }
        if (ipen == -2) {
            Toast.makeText(PaymentActivity.this, "无法打开串口：未知错误！", Toast.LENGTH_SHORT).show();
        }
        if (ipen == -3) {
            Toast.makeText(PaymentActivity.this, "无法打开串口：参数错误！", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_shipping:
                VioSerial.instance().openChannel(String.valueOf(110), 0);
                break;
        }
    }
}
