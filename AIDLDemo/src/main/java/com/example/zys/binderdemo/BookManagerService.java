package com.example.zys.binderdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zys on 16/12/20.
 */

public class BookManagerService extends Service {




    private List<Book> mBookList;

    private final IServiceManager.Stub mManager = new IServiceManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {

            if (mBookList==null) {
                mBookList=new ArrayList<>();
            }
            Log.d("TTAG", "getBooks: now the book list is "+mBookList.toString());
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this){
                if (mBookList==null) {
                    mBookList=new ArrayList<>();
                }

                if(book==null){
                    Log.e("TTAG", "Book is null in In" );
                }
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
                Log.d("TTAG", "addBook: now the book list is "+mBookList.toString());
            }
        }
    };

    public BookManagerService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList=new ArrayList<>();
        Book book = new Book();
        book.setName("Android");
        book.setPrice(28);
        mBookList.add(book);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TTAG", "onBind: "+intent.toString());
        return mManager;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
