# VolleyManager
安卓 Volley+OkHttp3+Gson 开源库的封装  

![asd](https://github.com/ALLENnan/VolleyManager/blob/master/screenshot/screenshot.jpg)

#Gradle
```java
compile 'com.jakewharton:butterknife:7.0.1'
compile 'com.mcxiaoke.volley:library:1.0.19'
compile 'com.google.code.gson:gson:2.6.1'
compile 'com.squareup.okhttp3:okhttp:3.1.2'
compile 'com.squareup.okio:okio:1.6.0'
```
#Sample
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
```java
  VolleyManager.newInstance().ImageLoaderRequest
                (mImageview, Urls.mImageUrl, R.mipmap.ic_default, R.mipmap.ic_error);
```
#Blog
[here](http://allenlin.leanote.com/post/volleyokhttpgson)

#其他  
有问题欢迎提交issue或者提交pull requests  
