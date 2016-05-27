package com.example.allen.volleymanager.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.allen.volleymanager.R;
import com.example.allen.volleymanager.config.Urls;
import com.example.allen.volleymanager.entity.Person;
import com.example.allen.volleymanager.volley.VolleyManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    @BindView(R.id.textview)
    TextView mTextview;
    @BindView(R.id.imageview)
    ImageView mImageview;
    @BindView(R.id.circleimageview)
    CircleImageView mCircleimageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
        postData();
        getImage();
        getCircleImage();

    }


    private void getData() {
        /**
         * 解析后台返回的json对象
         */
        VolleyManager.newInstance().GsonGetRequest(TAG, Urls.mJsonUrl, Person.class,
                new Response.Listener<Person>() {
                    @Override
                    public void onResponse(Person person) {
                        Log.v(TAG, "get方法: " + person.toString());
                        mTextview.setText(person.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                });
    }

    private void postData() {
        /**
         * 上传数据到后台
         */

        /*post方式一：post map参数*/
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "allen");
        map.put("password", "linqinan");

        VolleyManager.newInstance().GsonPostRequest(TAG, map, Urls.mJsonUrl, Person.class,
                new Response.Listener<Person>() {
                    @Override
                    public void onResponse(Person person) {
                        Log.v(TAG, "post map参数: " + person.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);

                    }
                });

        /*post方式一：post json对象*/
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "allen");
            jsonObject.put("password", "linqinan");
            Log.v(TAG, "本地json打印: " + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        VolleyManager.newInstance().PostjsonRequest(TAG, Urls.mJsonUrl, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.v(TAG, "post json对象: " + jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                });


    }


    private void getImage() {
        /**
         * 加载图片
         */
        VolleyManager.newInstance().ImageLoaderRequest
                (mImageview, Urls.mImageUrl, R.mipmap.ic_default, R.mipmap.ic_error);
    }

    private void getCircleImage() {
        /**
         * 加载圆形图片
         */
        VolleyManager.newInstance().ImageRequest(TAG, Urls.mImageUrl,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mCircleimageview.setImageBitmap(bitmap);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_INSIDE, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mCircleimageview.setImageResource(R.mipmap.ic_error);
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * 取消请求
         */
        if (VolleyManager.newInstance() != null) {
            VolleyManager.newInstance().cancel(TAG);
        }

    }
}
