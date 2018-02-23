package wechat.entity.message;

import java.util.List;

import wechat.entity.event.BaseEvent;



public class NewsMessage extends BaseMessage {
	
	   /**
     * 图文消息个数,限制为10条以内
     */
    private int ArticleCount;
    /**
     * 多条图文消息信息,默认第一个item为大图,
     * </p>
     * 注意:如果图文数超过10,则将会无响应
     */
    private List<Article> Articles;

    public NewsMessage() {
        super();
        this.MsgType = "news";
    }

    public NewsMessage(BaseEvent event) {
        super(event);
        this.MsgType = "news";
    }

    public NewsMessage(BaseMessage msg) {
        super(msg);
        this.MsgType = "news";
    }

    public int getCount() {
        return ArticleCount;
    }

    public void setCount(int count) {
        this.ArticleCount = count;
    }

    public List<Article> getArticles() {
        if (!Articles.isEmpty() && Articles.size() > 10) {
            this.Articles = Articles.subList(0, 10);
            setCount(10);
        }
        else {
            this.setCount(Articles.size());
        }
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }

    @Override
    public String toString() {
        return "NewsMsg [toUserName="
               + ToUserName
               + ", fromUserName="
               + FromUserName
               + ", createTime="
               + CreateTime
               + ", msgType="
               + MsgType
               + ", msgId="
               + MsgId
               + ", count="
               + ArticleCount
               + ", articles="
               + Articles
               + "]";
    }

}
