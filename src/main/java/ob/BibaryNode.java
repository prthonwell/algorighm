package ob;

import lombok.Data;

// 二叉树节点
@Data
public class BibaryNode {
    public int value;
    public BibaryNode left;
    public BibaryNode right;
    public BibaryNode(int value) {
        this.value = value;
    }

}
