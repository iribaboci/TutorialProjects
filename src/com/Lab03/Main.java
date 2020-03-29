package com.Lab03;

import java.util.*;

interface IList<E> extends Iterable<E> {
    boolean add(E e); // qdd element to the end of list
    void add(int index, E element) throws NoSuchElementException; // add element on position index
    void clear(); // delete all elements
    boolean contains(E element); // is list containing an element (equals())
    E get(int index) throws NoSuchElementException; //get element from position
    E set(int index, E element) throws NoSuchElementException; // set new value on position
    int indexOf(E element); // where is element (equals())
    boolean isEmpty();
    Iterator<E> iterator();
    ListIterator<E> listIterator() throws UnsupportedOperationException; // for ListIterator
    E remove(int index) throws NoSuchElementException; // remove element from position index
    boolean remove(E e); // remove element
    int size();
}

class TwoWayLinkedListWithHead<E> implements IList<E>{

    private class Element{
        public Element(E e) {
            this.object = e;
        }
        public Element(E e, Element next, Element prev) {
            this.object = e;
            this.next = next;
            this.prev = prev;
        }
        E object;
        Element next=null;
        Element prev=null;
    }

    Element head;
    // can be realization with the field size or without
    int size;

    private class InnerIterator implements Iterator<E>{
        Element pos;
        // TODO maybe more fields....

        public InnerIterator() {
            pos = head;
        }
        @Override
        public boolean hasNext() {

            return pos.next != head;
        }

        @Override
        public E next() {
            pos = pos.next;
            return pos.object;
        }
    }

    private class InnerListIterator implements ListIterator<E>{
        Element p;
        // TODO maybe more fields....

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();

        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void set(E e) {
            // TODO Auto-generated method stub

        }
    }

    public TwoWayLinkedListWithHead() {
        // make a head
        head=null;
    }

    @Override
    public boolean add(E e) {
        //TODO

        return true;
    }

    @Override
    public void add(int index, E element) {
        //TODO
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public boolean contains(E element) {
        //TODO
        return false;
    }

    @Override
    public E get(int index) {
        //TODO
        return null;
    }

    @Override
    public E set(int index, E element) {
        //TODO
        return null;
    }

    @Override
    public int indexOf(E element) {
        //TODO
        return -1;
    }

    @Override
    public boolean isEmpty() {
        //TODO

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        //TODO
        return null;
    }

    @Override
    public boolean remove(E e) {
        //TODO
        return true;
    }

    @Override
    public int size() {
        //TODO
        return -1;
    }
    public String toStringReverse() {
        ListIterator<E> iter=new InnerListIterator();
        while(iter.hasNext())
            iter.next();
        String retStr="";
        //TODO use reverse direction of the iterator
        return retStr;
    }

    public void add(TwoWayLinkedListWithHead<E> other) {
        //TODO
    }
}


class Link{
    public String ref;
    // in the future there will be more fields
    public Link(String ref) {
        this.ref=ref;
    }
    @Override
    public boolean equals(Object obj) {
        //TODO
        return true;
    }

}

class Document{
    public String name;
    public TwoWayLinkedListWithHead<Link> link;
    public Document(String name, Scanner scan) {
        this.name=name;
        link=new TwoWayLinkedListWithHead<Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static boolean correctLink(String link) {
        //TODO
        return true;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }

    public String toStringReverse() {
        String retStr="Document: "+name;
        return retStr+link.toStringReverse();
    }

}

public class Main {




    static Scanner scan; // for input stream





    public static void main(String[] args) {
        System.out.println("START");
        scan=new Scanner(System.in);
        Document[] doc=null;
        int currentDocNo=0;
        int maxNo=-1;
        boolean halt=false;
        while(!halt) {
            String line=scan.nextLine();
            // empty line and comment line - read next line
            if(line.length()==0 || line.charAt(0)=='#')
                continue;
            // copy line to output (it is easier to find a place of a mistake)
            System.out.println("!"+line);
            String word[]=line.split(" ");
            // go n - start with array of the length n
            if(word[0].equalsIgnoreCase("go") && word.length==2) {
                maxNo=Integer.parseInt(word[1]);
                doc = new Document[maxNo];
                continue;
            }
            //ch - change index
            if(word[0].equalsIgnoreCase("ch") && word.length==2) {
                currentDocNo=Integer.parseInt(word[1]);
                continue;
            }

            // ld documentName
            if(word[0].equalsIgnoreCase("ld") && word.length==2) {
                doc[currentDocNo]=new Document(word[1],scan);
                continue;
            }
            // ha
            if(word[0].equalsIgnoreCase("ha") && word.length==1) {
                halt=true;
                continue;
            }
            // clear
            if(word[0].equalsIgnoreCase("clear") && word.length==1) {
                doc[currentDocNo].link.clear();
                continue;
            }
            // show
            if(word[0].equalsIgnoreCase("show") && word.length==1) {
                System.out.println(doc[currentDocNo].toString());
                continue;
            }
            // reverse
            if(word[0].equalsIgnoreCase("reverse") && word.length==1) {
                System.out.println(doc[currentDocNo].toStringReverse());
                continue;
            }
            // size
            if(word[0].equalsIgnoreCase("size") && word.length==1) {
                System.out.println(doc[currentDocNo].link.size());
                continue;
            }
            // add str
            if(word[0].equalsIgnoreCase("add") && word.length==2) {
                System.out.println(doc[currentDocNo].link.add(new Link(word[1])));
                continue;
            }
            // addi index str
            if(word[0].equalsIgnoreCase("addi") && word.length==3) {
                int index=Integer.parseInt(word[1]);
                try {
                    doc[currentDocNo].link.add(index, new Link(word[2]));
                }
                catch (NoSuchElementException e) {
                    System.out.println("error");
                }
                continue;
            }
            // get index
            if(word[0].equalsIgnoreCase("get") && word.length==2) {
                int index=Integer.parseInt(word[1]);
                try {
                    Link l=doc[currentDocNo].link.get(index);
                    System.out.println(l.ref);
                }
                catch(NoSuchElementException e) {
                    System.out.println("error");
                }
                continue;
            }
            // set index str
            if(word[0].equalsIgnoreCase("set") && word.length==3) {
                int index=Integer.parseInt(word[1]);
                try {
                    Link l=doc[currentDocNo].link.set(index,new Link(word[2]));
                    System.out.println(l.ref);
                }
                catch(NoSuchElementException e) {
                    System.out.println("error");
                }

                continue;
            }
            // index str
            if(word[0].equalsIgnoreCase("index") && word.length==2) {
                int index=doc[currentDocNo].link.indexOf(new Link(word[1]));
                System.out.println(index);
                continue;
            }
            // remi index
            if(word[0].equalsIgnoreCase("remi") && word.length==2) {
                int index=Integer.parseInt(word[1]);
                try {
                    Link l=doc[currentDocNo].link.remove(index);
                    System.out.println(l.ref);
                }
                catch(NoSuchElementException e) {
                    System.out.println("error");
                }
                continue;
            }
            // rem str
            if(word[0].equalsIgnoreCase("rem") && word.length==2) {
                System.out.println(doc[currentDocNo].link.remove(new Link(word[1])));
                continue;
            }
            // addl <indexOfListArray>
            if(word[0].equalsIgnoreCase("addl") && word.length==2) {
                int number=Integer.parseInt(word[1]);
                doc[currentDocNo].link.add(doc[number].link);
                continue;
            }
            System.out.println("Wrong command");
        }
        System.out.println("END OF EXECUTION");
        scan.close();

    }




}