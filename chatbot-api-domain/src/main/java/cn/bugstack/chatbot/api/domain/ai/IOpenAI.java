package cn.bugstack.chatbot.api.domain.ai;

import java.io.IOException;

public interface IOpenAI {
    String dochatgpt(String question) throws IOException;

}
