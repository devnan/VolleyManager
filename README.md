# VolleyManager
A simple li using Volley,OkHttp3 and Gson.

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
                        mTextview.setText(person.toString());
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
![here](http://allenlin.leanote.com/post/volleyokhttpgson)
