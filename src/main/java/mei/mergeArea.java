//package mei;
//
//import java.util.Arrays;
//import java.util.TreeMap;
//
//public class mergeArea {
//    public static class AreaNode {
//        public int x;
//        public int y;
//        public int left;
//        public int right;
//        public int bottom;
//        public int top;
//        int time;
//        int k;
//        int boomer;
//        public AreaNode leftNode;
//        public AreaNode rightNdoe;
//
//    }
//
//    public static class AreaTree {
//        public static AreaNode root;
//        static int boomer = 1;
//        static int
//        public AreaTree(AreaNode root) {
//            this.root = root;
//        }
//
//        public AreaTree () {
//            root = null;
//        }
//
//        public void insert (AreaNode node) {
//            if (root == null) {
//                root = node;
//            } else {
//                AreaNode cur = root;
//                // 查看是否可以融合
//
//                // 向左或右继续判断
//                while (cur != null) {
//                    int res = CanMerge(cur, node);
//                    if (res == 1) {
//                        cur = cur.rightNdoe;
//                    }
//                    else if (res == -1) {
//                        cur = cur.leftNode;
//                    } else {
//                        break;
//                    }
//                }
//                cur = node;
//            }
//        }
//        public int CanMerge(AreaNode cur, AreaNode node) {
//            if (node == null) {
//                return 0;
//            }
//            if (node.x <= cur.right && node.x >= cur.left && node.y <= cur.top && node.y >= cur.bottom) {
//                cur.right = Math.max(cur.right, node.right);
//                cur.top = Math.max(cur.top, node.top);
//                cur.bottom = Math.min(cur.bottom, node.bottom);
//                cur.left = Math.min(cur.left, node.left);
//                cur.time = Math.min(cur.time,node.time);
//                cur.boomer++;
//                this.boomer = Math.max(this.boomer, node.boomer);
//                CanMerge(cur, cur.leftNode);
//                CanMerge(cur, cur.rightNdoe);
//                return 0;
//            } else if (node.x + node.y > cur.x + cur.y) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//    }
//    public static int MergeArea(AreaNode[] areas) {
//        TreeMap<Integer, AreaNode> map = new TreeMap<>();
//        Arrays.stream(areas).forEach(area -> {
//            map.put(area.k, area);
//        });
//        AreaTree areaTree = new AreaTree();
//        while (map.size() > 1) {
//            AreaNode value = map.firstEntry().getValue();
//            areaTree.insert(value);
//        }
//    }
//}
