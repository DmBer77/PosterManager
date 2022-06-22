package ru.netology.posters;

public class PostersRepository {
   private Posters[] items = new Posters[0];

   public void saveNewPoster(Posters item) {
       Posters[] tmp = new Posters[items.length + 1];
       for (int i = 0; i < items.length; i++) {
           tmp[i] = items[i];
       }
       tmp[tmp.length - 1] = item;
       items = tmp;
   }

   public void removePoster(String posterName) {
       Posters [] tmp = new Posters[items.length - 1];
       int copyToIndex = 0;
       for (Posters item : items) {
           if (!item.getPosterName().equals(posterName)){
               tmp[copyToIndex] = item;
               copyToIndex++;
           }
       }
       items = tmp;
   }

   public Posters[] getItems() {
       return items;
   }
}
