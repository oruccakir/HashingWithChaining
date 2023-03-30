

public class MyHashWithChaining<T> {

    private LinkedList<T> hashTable [];

    public int length;

    private double loadFactor; 

    private int numberOfData = 0;

    public MyHashWithChaining(){

        this.hashTable = new LinkedList[19];

        this.length = 19;

        for(int i=0; i<19; i++)
            hashTable[i] = new LinkedList<T>();

        loadFactor =0.0;
        numberOfData=0;

    }

    public MyHashWithChaining(int length){

        this.length = length;

        this.hashTable = new LinkedList[this.length];

        for(int i=0; i<this.length; i++)
            this.hashTable[i] = new LinkedList<>();

        loadFactor = 0.0;
        numberOfData=0;

    }

    private int hashFunction(T data){

        return (Integer) data % this.length;

    }

    public boolean add(T data){

        if(data == null ) return false;

        int indexOfData = this.hashFunction(data);

        LinkedList <T>currentList = hashTable[indexOfData];

        if(!currentList.contains(data)){

            currentList.add(data);

            this.numberOfData++;

            loadFactor = numberOfData/this.length;

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

            numberOfData--;

            loadFactor = numberOfData / this.length;

            return true;
        }

        return false;
    }

    public boolean contains(T data){

        if(data == null) return false;

        int indexOfData = this.hashFunction(data);

        LinkedList<T> currentList = hashTable[indexOfData];

        if(currentList.contains(data))  return true;

        return false;

    }

    public void printIndexes(){

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

    public void printValues(){

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
