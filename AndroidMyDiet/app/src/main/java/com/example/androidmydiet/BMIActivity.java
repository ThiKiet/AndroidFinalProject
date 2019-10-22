package com.example.androidmydiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView TvName = findViewById(R.id.tvName);
        TextView TvWeight = findViewById(R.id.tvWeight);
        TextView TvHeight = findViewById(R.id.tvHeight);
        TextView TvBIM = findViewById(R.id.tvBMI);
        TextView Picture = findViewById(R.id.tvPicture);
        Button back = findViewById(R.id.btnBack);
        Button choose = findViewById(R.id.btnChoose);

        final Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        final float weight = intent.getFloatExtra("weight", 0.0f);
        final float height = intent.getFloatExtra("height", 0.0f);
        final float BIMNumber = intent.getFloatExtra("BIMNumber", 0.0f);

        TvName.setText("Tên của bạn là: "+name);
        TvWeight.setText("Cân nặng: "+Math.round(weight) + "kg");
        TvHeight.setText("Chiều cao: " +Math.round(height) + "cm");
        TvBIM.setText("Chỉ số BMI: " + Math.round(BIMNumber));

        if(BIMNumber < 18.5){
            Picture.setText("BMI của bạn bình thường. Bạn có thể được xem là nhẹ cân nếu chỉ số BMI dưới 18,5. " +
                    "Nếu bạn muốn tăng cân, hãy nắm rõ nhu cầu calo của cơ thể để phục vụ cho hoạt động hàng ngày và từ đó tính toán chế độ ăn uống để dung nạp nhiều calo hơn mức cần thiết." +
                    " Bạn có thể bổ sung khoảng 300–500 kcal trong khẩu phần ăn của mình." +
                    " một ngày bạn cần 1.700 kcal thì lượng calo bạn cần hấp thu là 1700+500=2.200 kcal");
        }
        else if(BIMNumber >= 18.5 && BIMNumber < 24.9) {
            Picture.setText("BMI của bạn khỏe mạnh. Bạn được xem là có cân nặng chuẩn nếu có chỉ số BMI dao động từ 18,5 – 24,9. "+
                    "Để duy trì cân nặng chuẩn, bạn cần biết lượng calo cần dung nạp để đảm bảo chế độ ăn uống đáp ứng nhu cầu của cơ thể. "+
                    "Ví dụ: Nếu nhu cầu của cơ thể là 1.950 kcal/ngày, bạn nên dung nạp cho cơ thể tổng lượng đồ ăn và thức uống là 1.950 kcal mỗi ngày");
        }
        else if(BIMNumber >= 24.9 && BIMNumber < 29.9){
            Picture.setText("Bạn sẽ bị xem là thừa cân nếu chỉ số BMI từ 24,9 to 29,9"+
                    " Để có thể giảm cân hiệu quả, bạn cần nắm rõ nhu cầu calo của cơ thể phục vụ cho hoạt động hàng ngày và từ đó tính toán chế độ ăn uống để dung nạp ít calo hơn mức cần thiết." +
                    " Bạn có thể cắt giảm từ 300–500 kcal trong khẩu phần ăn hàng ngày và từ đó giảm được từ 0,5–1 kg mỗi tuần. " +
                    "Ví dụ: Nếu lượng calo hàng ngày của bạn là 2.100, bạn chỉ cần bổ sung 1.600 kcal từ các loại đồ ăn và thức uống.  Trung bình, phụ nữ cần khoảng 2.000 kcal hàng ngày, " +
                    "nam giới cần 2.500 kcal. Để có thể giảm cân, bạn cần cắt giảm 500 kcal mỗi ngày. " +
                    "Tuy nhiên, mỗi người cần ít nhất 1.200 kcal để duy trì các hoạt động của cơ thể hàng ngày." +
                    " Nếu bạn dung nạp ít hơn lượng calo tiêu chuẩn thì sẽ ảnh hưởng xấu đến cơ thể.");
        }
        else if(BIMNumber >= 30){
            Picture.setText("Bạn sẽ bị xem là béo phì độ 2 nếu chỉ số BMI từ 30 trở lên. Để có thể giảm cân, bạn cần nắm rõ nhu cầu calo của cơ thể phục vụ cho hoạt động hàng ngày " +
                    "và từ đó tính toán chế độ ăn uống để dung nạp ít calo hơn mức cần thiết. " +
                    "Bạn có thể cắt giảm từ 300–500 kcal trong khẩu phần ăn hàng ngày và từ đó giảm được từ 0,5–1 kg mỗi tuần. Lượng calo hàng ngày của bạn là 2.100," +
                    " bạn chỉ cần bổ sung 1.600 kcal từ các loại đồ ăn và thức uống. Trung bình, phụ nữ cần khoảng 2.000 kcal hàng ngày" +
                    "Nam giới cần 2.500 kcal. Để có thể giảm cân, bạn cần cắt giảm 500 kcal mỗi ngày. " +
                    "Tuy nhiên, mỗi người cần ít nhất 1.200 kcal để duy trì các hoạt động của cơ thể hàng ngày. Nếu bạn dung nạp ít hơn lượng calo tiêu chuẩn thì sẽ ảnh hưởng xấu đến cơ thể.");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent1, 0);
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BIMNumber < 18.5){
                    Intent slimIntent = new Intent(BMIActivity.this, SlimActivity.class);
                    startActivity(slimIntent);
                }
                else if(BIMNumber >= 18.5 && BIMNumber < 24.9) {
                    Intent mediumIntent = new Intent(BMIActivity.this, MediumActivity.class);
                    startActivity(mediumIntent);
                }
                else if(BIMNumber >= 24.9 && BIMNumber < 29.9){
                    Intent fatIntent = new Intent(BMIActivity.this, FatActivity.class);
                    startActivity(fatIntent);
                }
                else if(BIMNumber >= 30){
                    Intent fat1Intent = new Intent(BMIActivity.this, FatActivity.class);
                    startActivity(fat1Intent);
                }

            }
        });

    }
}
