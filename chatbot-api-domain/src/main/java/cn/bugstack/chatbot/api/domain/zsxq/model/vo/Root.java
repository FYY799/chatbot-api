package cn.bugstack.chatbot.api.domain.zsxq.model.vo;

import java.util.ArrayList;
import java.util.List;
public class Root
{
    private List<Topics> topics;

    public void setTopics(List<Topics> topics){
        this.topics = topics;
    }
    public List<Topics> getTopics(){
        return this.topics;
    }
}