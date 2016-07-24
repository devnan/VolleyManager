# VolleyManager
安卓 Volley+OkHttp3+Gson 开源库的封装（暂没有对提供Https的支援，只适合不要求传输安全性的项目）

![asd](https://github.com/ALLENnan/VolleyManager/blob/master/screenshot/image.jpg)

#Gradle
```java
    compile 'com.jakewharton:butterknife:8.0.1'   
    apt 'com.jakewharton:butterknife-compiler:8.0.1'   
    compile 'com.mcxiaoke.volley:library:1.0.19'
    compile 'com.google.code.gson:gson:2.6.1'
    compile 'com.squareup.okhttp3:okhttp:3.1.2'
    compile 'com.squareup.okio:okio:1.6.0'
    compile 'de.hdodenhof:circleimageview:2.0.0'
```
#Sample  
####1.get方法示例
```java
        VolleyManager.newInstance().GsonGetRequest(TAG, Urls.mJsonUrl, Person.class,
                new Response.Listener<Person>() {
                    @Override
                    public void onResponse(Person person) {
                        Log.v(TAG, person.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                });
```

####2.post map参数示例
```java
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "allen");
        map.put("password", "linqinan");

        VolleyManager.newInstance().GsonPostRequest(TAG, map, Urls.mJsonUrl, Person.class,
                new Response.Listener<Person>() {
                    @Override
                    public void onResponse(Person person) {
                        Log.v(TAG, person.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);

                    }
                });
```

####3.post json对象示例
```java
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "allen");
            jsonObject.put("password", "linqinan");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        VolleyManager.newInstance().PostJsonRequest(TAG, Urls.mJsonUrl, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.v(TAG, jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                });

```

####4.加载图片示例
```java
  VolleyManager.newInstance().ImageLoaderRequest
                (mImageview, Urls.mImageUrl, R.mipmap.ic_default, R.mipmap.ic_error);
```
####5.加载圆形图片示例(使用了[CircleImageView](https://github.com/hdodenhof/CircleImageView)库)
```java
        @Bind(R.id.circleimageview)
        CircleImageView mCircleimageview;
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

```

####具体看项目的sample

#Blog
[here](http://allenlin.leanote.com/post/volleyokhttpgson)

#其他
有问题欢迎提交issue或者提交pull request
