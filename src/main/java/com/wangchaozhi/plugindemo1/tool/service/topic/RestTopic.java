package com.wangchaozhi.plugindemo1.tool.service.topic;

/**
 * @author ZhangYuanSheng
 * @version 1.0
 */
public interface RestTopic<T> {

    /**
     * action
     *
     * @param data data
     */
    default void action(T data) {
        // default
    }
}
