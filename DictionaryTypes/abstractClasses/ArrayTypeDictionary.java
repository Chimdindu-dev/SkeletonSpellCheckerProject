package DictionaryTypes.abstractClasses;

public abstract class ArrayTypeDictionary extends Dictionary {

    /* ARRAY SPECIFIC METHODS handin2*/
    public void insertionSort(String[] arr, int finalIndexForSort) {
        //todo
        String temp = "";
        for (int i = 0; i < finalIndexForSort; i++) {
            for (int j = i + 1; j < finalIndexForSort; j++) {
                if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
                System.out.print(arr[i]);
            }
        }
    }

    public void mergeSort(String[] arr, int finalIndexForSort) {
        //todo
        if (arr.length < 2){
            return;
        }
        int a = finalIndexForSort/2;
        String[] left = new String[a];
        String[] right = new String[finalIndexForSort - a];

        for (int i = 0; i < a; i++) {
                left[i] = arr[i];
            }
        for (int i = a; i < finalIndexForSort; i++) {
            right[i - a] = arr[i];
        }
        mergeSort(left, a);
        mergeSort(right, finalIndexForSort - a);

        merge(arr, left, right);
    }

    public static void merge(String[] a, String[] l, String[] r) {

        int aaa = 0;
        int bbb = 0;
        for (int i = 0; i < a.length; i++) {
            if (bbb >= r.length || (aaa < l.length && l[aaa].compareToIgnoreCase(r[bbb]) < 0)) {
                a[i] = l[aaa];
                aaa++;
            } else {
                a[i] = r[bbb];
                bbb++;
            }
        }
    }

    public void hybridSort(String[] arr, int size, int finalIndexForSort) {
        //todo
        if(arr.length<= size){
            insertionSort(arr,finalIndexForSort);
        }else if(arr.length > size){
            mergeSort(arr,finalIndexForSort);
        }
    }
    
}
