import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    
    public MapNode head;
    public MapNode parent;
    public int size;
    
    public MyTreeMap ( ) {
        head = null;
        parent = null;
        size = 0;
    }
    
    public MyTreeMap (MapNode m) {
        head = m;
        parent = null;
        size = 0;
    }
    
    public static void main (String[] args) {
        MyTreeMap tree = new MyTreeMap();
        // System.out.println(tree.put(10, "10"));
        // tree.put(15, "15");
        // System.out.println(tree.put(10,"ten"));
        // tree.put(14, "14");
        // tree.put(16, "16");
        // tree.put(7, "7");
        // tree.put(5, "5");
        // tree.put(8, "8");
        // System.out.println("Size = " + tree.size());
        // System.out.println(tree.containsKey(10));
        // System.out.println(tree.containsKey(1));
        // System.out.println(tree.containsKey(15));
        // System.out.println(tree.containsKey(14));
        // System.out.println(tree.containsKey(16));
        // System.out.println(tree.containsKey(7));
        // System.out.println(tree.containsKey(5));
        // System.out.println(tree.containsKey(2));
        // System.out.println(tree.remove(5));
        // System.out.println(tree.containsKey(10));
        // // System.out.println(tree.containsKey(1));
        // System.out.println(tree.containsKey(15));
        // System.out.println(tree.containsKey(14));
        // System.out.println(tree.containsKey(16));
        // System.out.println(tree.containsKey(7));
        // System.out.println(tree.containsKey(5));
        // tree.get(10);
        // tree.get(15);
        // tree.get(14);
        // tree.get(16);
        // tree.get(7);
        // // tree.get(5);
        // tree.get(8);

        // Date a  = new Date(4,29,1991);
        // Event birth = new Event("Birthday");

        // Date b = new Date(4,29,1991);
        // Event temp = new Event("Birthdasy");

        // // System.out.println(a.compareTo(b));
        // // MyTreeMap thai = new MyTreeMap();
        // // thai.put(a,birth);
        // // thai.put(b,temp);
        // System.out.println(birth.equals(temp));


    }
        
    @Override
    public V get(Object key) {
        if (head != null && containsKey(key)) {
            return head.get((K) key);
        }
        throw new NoSuchElementException ("key not contained");
    }

    @Override
    public V put(K key, V value) {
        if(size() == 0) {
            head = put(head, key, value);
            size++;
            return null;
        }
        if(containsKey(key)) {
            return replace(head, key, value);
        }
        head = put(head, key, value);
        size++;
        return get(key);
    }

    public MapNode put (MapNode node, K key, V value) {
        if (node == null) {
            return new MapNode(key, value);
        } else if (((Comparable) key).compareTo(node.myKey) < 0) {
            node.left = put(node.left, key, value);
        } else if (((Comparable) key).compareTo(node.myKey) > 0) {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    public V replace(MapNode node, K key, V value) {
        if(((Comparable) key).compareTo(node.myKey) == 0) {
            V temp  = node.myValue;
            node.myValue = value;
            return temp;
        }
        else if(((Comparable) key).compareTo(node.myKey) < 0) {
            return replace(node.left, key, value);
        } 
        else {
            return replace(node.right, key, value);
        }

    }
    
    @Override
    public boolean containsKey(Object key) {
        if (head != null) {
            return head.containsKey((K) key);
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (head != null) {
            return head.containsValue(value);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V remove (Object key) {
        if(head.myKey == key) {
            V rtn = get(key);
            MapNode temp =  head.right.findSuccessor(null);
            temp.left = head.left;
            temp.right = head.right;
            head.left = null;
            head.right = null;
            head = temp;
            return rtn;
        }

        else if (head != null) {
            if (head.containsKey(key)) {
                V rtn = get(key);
                head.remove(key, parent);
                return rtn;
            }
        }
        throw new NoSuchElementException ("key not contained");
    }
    
    private class MapNode {
        
        private K myKey;
        private V myValue;
        private MapNode left;
        private MapNode right;
    
        public MapNode ( ) {
            myKey = null;
            myValue = null;
            left = null;
            right = null;
        }
    
        public MapNode (K key, V value) {
            myKey = key;
            myValue = value;
            left = null;
            right = null;
        }
    
        public MapNode (MapNode nodeCopy) {
            this.myKey = nodeCopy.myKey;
            this.myValue = nodeCopy.myValue;
            this.left = nodeCopy.left;
            this.right = nodeCopy.right;
        }
    
        public V get (K key) {
            if (this.myKey == key) {
                return this.myValue;
            } else if (((Comparable) key).compareTo(this.myKey) < 0) {
                return left.get(key);
            } else {
                return right.get(key);
            }
        }
    
        public boolean containsKey (Object key) {
            
            if (this.myKey == key) {
                return true;
            } else if (this.left == null && this.right == null) {
                return false;
            } else if (((Comparable) key).compareTo(this.myKey) < 0 && this.left != null) {
                return this.left.containsKey(key);
            } else if(((Comparable) key).compareTo(this.myKey) > 0 && this.right != null) {
                return this.right.containsKey(key);
            }
            return false;
        }
        
        public boolean containsValue (Object value) {
            if (this.myValue == value) {
                return true;
            } else if (this.left == null && this.right == null) {
                return false;
            } else if (this.left != null) {
                return this.left.containsValue(value);
            } else if (this.right != null) {
                return this.right.containsValue(value);
            }
            return this.left.containsValue(value) || this.right.containsValue(value);
        }
    
        public int size ( ) {
            if (this.left == null && this.right == null) {
                return 1;
            } else if (this.left == null) {
                return 1 + this.right.size();
            } else if (this.right == null) {
                return 1 + this.left.size();
            }
            return 1 + this.left.size() + this.right.size();
        }
    
        
        public void remove(Object key, MapNode parent) {
            if (this.myKey == key) {
                if(this.right == null) {
                    if(parent.right == this) {     // no successor
                        MapNode temp = this;
                        parent.right = temp.left;
                        this.left = null;
                        this.right = null;
                    } else if(parent.left == this) {  // no successor
                        MapNode temp = this;
                        parent.left = temp.left;
                        this.left = null;
                        this.right = null;
                    }
                }
                else if (parent != null || this.right != null ) {
                    MapNode temp = this.right.findSuccessor(this);
                    if(parent.right == this) {
                        temp.left = this.left;
                        parent.right = temp;
                    }
                    else if(parent.left == this) {
                        temp.left = this.left;
                        parent.left = temp;

                    }
                } 
                else {
                    parent.left = null;
                } 

            }
            else if (this.left != null && ((Comparable) key).compareTo(this.myKey) < 0) {
                this.left.remove(key, this);
            } 
            else if (this.right != null && ((Comparable) key).compareTo(this.myKey) > 0) {
                this.right.remove(key, this);
            }
        }   
    
        public MapNode findSuccessor (MapNode parent) {
            if (this.left == null && parent != null) {
                MapNode temp = new MapNode(this.myKey, this.myValue);
                temp.right = this.right;
                temp.left = this.left;
                if(parent.right == this) {
                    parent.right = this.right;
                }
                else if(parent.left == this) {
                    parent.left = this.right;
                }
                return temp;
            }
            return this.left.findSuccessor(this);
        }
    }
    
    // The methods below do not need to be implemented for the homework.
    // They are provided only to satisfy the Map interface.
    
    @Override
    public Collection<V> values() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }
    
    @Override
    public void clear() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
    }
    
    @Override
    public Set<K> keySet() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
    } 

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }
}
