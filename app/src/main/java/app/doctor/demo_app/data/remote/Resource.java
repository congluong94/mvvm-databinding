package app.doctor.demo_app.data.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import static app.doctor.demo_app.data.remote.Status.ERROR;
import static app.doctor.demo_app.data.remote.Status.LOADING;
import static app.doctor.demo_app.data.remote.Status.SUCCESS;

/**
 * Created by luonglc on 5/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class Resource<T> {
    @NonNull
    public Status status;

    @Nullable
    public T data;

    @Nullable
    private String message;

    @SerializedName("code_msg")
    private String codeMsg;

    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    public String getCodeMsg() {
        return codeMsg;
    }
}