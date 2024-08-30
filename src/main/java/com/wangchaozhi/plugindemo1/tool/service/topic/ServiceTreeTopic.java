package com.wangchaozhi.plugindemo1.tool.service.topic;

import com.wangchaozhi.plugindemo1.tool.beans.Request;
import com.intellij.util.messages.Topic;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangYuanSheng
 * @version 1.0
 */
public interface ServiceTreeTopic extends RestTopic<Map<String, List<Request>>> {

    Topic<ServiceTreeTopic> TOPIC = Topic.create("RestTopic.ServiceTreeTopic", ServiceTreeTopic.class);

    /**
     * action
     *
     * @param data data
     */
    @Override
    void action(@NotNull Map<String, List<Request>> data);
}
