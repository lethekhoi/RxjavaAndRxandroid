package com.example.rxjavaandrxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<String> observableNames = Observable.just("Teo", "Ti", "Tun");
//        List<String> arrayNames = new ArrayList<>();
//        arrayNames.add("Nguyen Van A");
//        arrayNames.add("Nguyen Van B");
//        arrayNames.add("Nguyen Van C");
//        Log.d("BBB", arrayNames.size() + "");
//        Iterator<String> iterator = arrayNames.iterator();
//        while (iterator.hasNext()) {
//            Log.d("BBB", iterator.next());
//        }
        observableNames.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d("BBB", s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                disposable.dispose();
            }
        });


    }
}
