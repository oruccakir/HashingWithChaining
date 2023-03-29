

public class MyHashWithChaining<T> {

    public LinkedList<T> hashTable [];

    public int length;

    public MyHashWithChaining(){

        this.hashTable = new LinkedList[19];

        this.length = 19;

        for(int i=0; i<19; i++)
            hashTable[i] = new LinkedList<T>();

    }

    public MyHashWithChaining(int length){

        this.length = length;

        this.hashTable = new LinkedList[this.length];

        for(int i=0; i<this.length; i++)
            this.hashTable[i] = new LinkedList<>();

    }

    private int hashFunction(T data){

        return (Integer) data % this.length;

    }

    public boolean insert(T data){

        if(data == null ) return false;

        int indexOfData = this.hashFunction(data);

        LinkedList <T>currentList = hashTable[indexOfData];

        if(!currentList.contains(data)){
            currentList.add(data);
            return true;
        }

        return false;

    }

    public boolean remove(T data){

        if(data == null) return false;

        int indexOfData = this.hashFunction(data);

        LinkedList <T>currentList = hashTable[indexOfData];

        int indexOfElement = currentList.indexOf(data);


        if(currentList.get(indexOfElement).equals(data)){
            currentList.remove(indexOfElement);
            return true;
        }

        return false;
    }

    public boolean search(T data){

        if(data == null) return false;

        int indexOfData = this.hashFunction(data);

        LinkedList<T> currentList = hashTable[indexOfData];

        if(currentList.contains(data))  return true;

        return false;

    }

    public void showIndexes(){

        for(int i=0; i<this.length; i++){

            System.out.print(""+i+" --> [ ");

            for(int k=0; k<this.hashTable[i].length; k++){

                LinkedList <T> currentLinkedList = this.hashTable[i];

                T data = currentLinkedList.get(k);

                int index = this.hashFunction(data);

                System.out.print(index+", ");

            }

            System.out.print("]");

            System.out.println();


        }

    }

    public void showValues(){

        for(int i=0; i<this.length; i++){

            System.out.print(""+i+" --> [ ");

            for(int k=0; k<this.hashTable[i].length; k++){
                System.out.print(this.hashTable[i].get(k)+", ");

            }

            System.out.print("]");
            System.out.println();

        }



    }




}
