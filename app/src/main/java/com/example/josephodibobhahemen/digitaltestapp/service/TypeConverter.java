package com.example.josephodibobhahemen.digitaltestapp.service;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */
public final class TypeConverter {

    /**
     * The interface Xml.
     */
    @Retention(RUNTIME)
        @interface Xml {
        }

    /**
     * The type Typed xml converter.
     */
    public static class TypedXmlConverter extends  Converter.Factory {
        private final Converter.Factory xmlFactory;

        /**
         * Instantiates a new Typed xml converter.
         *
         * @param xmlFactory the xml factory
         */
        public TypedXmlConverter(Converter.Factory xmlFactory) {
            this.xmlFactory = xmlFactory;
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof Xml) {
                    return xmlFactory.responseBodyConverter(type, annotations, retrofit);
                }
            }

            return null;
        }

        @Override
        public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            for (Annotation annotation : parameterAnnotations) {
                if (annotation instanceof Xml) {
                    return xmlFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations,
                            retrofit);
                }
            }

            return null;
        }
    }
}
