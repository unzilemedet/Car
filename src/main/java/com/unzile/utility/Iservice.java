package com.unzile.utility;

import java.util.List;
import java.util.Optional;

/*
* <T> ---> Entitynin adı Type
* <ID> ----> Entity nin @Id ile işaretlenmiş alanını DataTYPE I
* */
public interface Iservice <T,ID>{
    T save (T t);
    /*Belli bir entity listesini kaydetmek için kullanırız . Kayıt işleminden sonra
    * kaydedilen tüm kayıtların almış oldukları idler ile listesini döneriz */
  /*  Iterable<T> saveAll(Itarable<T> entities);*/
    T update(T t);
    void delete(T t);
    void deleteById(ID id);
   Optional<T>  findById(ID id);
    List<T> findAll();
}
