package com.muhammet.repository.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * Java içinde varlık olarak tanımlanan sınıfımızın özelliklerini belirliyor ve
 * bir Entity olduğunu belirtiyoruz. böylelikle hibernate bunu map edebiliyor.
 */
@Entity(name = "Musteri")
/**
 * Hibernate in java sınıfımızı eşleştireceği Veritabanında ki tablonun özelliklerini
 * burada belirtiyoruz.
 */
@Table(name = "tblmusteri",schema = "public", catalog = "hibernateornek",
        uniqueConstraints = {
            @javax.persistence.UniqueConstraint(columnNames = "musterino")
        }
        )
public class Musteri {
    /**
     * Her varlığın mutlaka bir id si olmalıdır ve bu id @Id ile işaratelenmelidir. 
     * hibernate tablo-class ilişkisini kurarken bunlar üzerinden kuracaktır.
     * 
     * int -> 2^32 -> 4byte
     * long -> 2^64 -> 8byte
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // her bir tablo için ayrı seq oluşturur.
    Long id;
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // her br tablo için sequence oluşturur.
    Long other_id;
    @GeneratedValue(strategy = GenerationType.AUTO) // tek bir sayaç üzerinden tüm tablolarımızı numaralandırma yapılır.
    Long other2_id;
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long other3_id;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy ="uuid2")        
    UUID uuid;
    @SequenceGenerator(name = "sq_musterino", // java içi seq name
            sequenceName = "sq_musterino", // database üzerindeki name
            initialValue = 6000, // başlangıç değeri
            allocationSize = 5 // artım sayısı 
    )
    @GeneratedValue(generator = "sq_musterino",strategy = GenerationType.SEQUENCE)        
    Long musterino;
    
    //-------------------------------------------------------------------
    /**
     * Kolon bilgileri eğer özellikle belirtilmez ise default değerler ile yoluna devam eder.
     */
    @Column(
        length = 100, // ad alanını DB de tutacağı karakter uzunluğu - Default[255]
        name = "name", // ilgili alan adının DB de oluşturulacağı adı
        unique = false, // bir alanın benzersiz olup olmayacağı belirtilir. true olursa aynı değer başka bir 
                        // kayıt tarafından kullanılamaz.
        insertable = true, // bu alan eğer false yapılır ise buraya girilen kayıtlar DB ye yansıtılmaz.
        updatable = false // bu alan false olur ise var olan kayıt asla değiştirilmez.
    )
    String ad;
    /**
     * Büyük veriler datalar tutacak iseniz kullanılır. Bunlar genellikle,
     * base64 formatında tutulan dosyalar şeklinde karşımıza çıkar.
     */
    @Lob
    String adres;
    
    Long kayittarihi;
    
    /**
     * tarih değişkenlerini kullanabilmek için kullanmak zorundasınız.
     * @Temporal
     * -> Date = TemporalType.DATE  -- tarih - 01.05.2023 Çarşamba
     * -> Time = TemporalType.TIME  -- zamanı - 15:30:25.015 
     * -> Timestamp = TemporalType.TIMESTAMP -- zaman damgası - Çarşamba, 19 Nisan 2023 14:22:51 GMT+03:00
     */
    @Temporal(TemporalType.TIMESTAMP)
    Date dogumtarihi;
    /**
     * Embedable sınıfların entity içine dahil edilmesini sağlar
     */
    @Embedded
    BaseEntity baseEntity;
    
    /**
     * Koleksiyonların hibernate tarfından yönetilebilmesi ve gerekli tabloların oluşturulabilmesi için
     * aşağıdaki anotasyonun eklenmesi gereklidir.
     * sistem şöyle işliyor;
     * hobiler ayrı bir tabloda tutuluyor ve bağlanılan tablonun id si bu yeni tabloda foreign key olarak 
     * ekleniyor.
     */
    @ElementCollection
    /**
     * Eğer hibernate tarafından otomatik olarak oluşturulan tablonun özelleştirilmesini 
     * istiyor ise, bunu düzenleyebileceğimiz @CollectionTable anoaayonunu kullanırız.
     */
    @CollectionTable(name = "tblmusteri_hobileri",schema = "public", catalog = "hibernateornek",
          joinColumns = @JoinColumn(name = "musteri_id")  ) 
    List<String> hobileri;
    /**
     * EnumType.ORDINAL -> seçilen enum un sayısal değerini DB ye yazar
     * EnumType.STRING ->  seçilen enum un String değerini DB ye yazar
     */
    @Enumerated(EnumType.STRING)
    Cinsiyet cinsiyet;
    
    @ElementCollection
    @CollectionTable(name = "tblmusteri_adresleri", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "adrestipi")
    @MapKeyEnumerated(EnumType.STRING)
    Map<AdresTipi, String> adresler;
    
    String soyad;
    
    /**
     * Veritabanında tutulmasını istemediğimiz ancak sınıf içinde bir konfsiyonu olan 
     * değişken türlerini aşağıdaki anotasyon ile işaretlemeyiliz.
     */
    @Transient
    String adsoyad;
    
    //---------------------------------------------------------------------------------
    /**
     * Tablolar arasındaki ilişkilerin hibernate üzerinden tanımlanması.
     * Tablolar arasında ilişkiler şu şekilde listelenir;
     * 1 den 1 e -> OneToOne
     * 1 den çoğa -> OneToMany
     * Çoktan 1 e -> ManyToOne
     * Çoktan Çoğa -> ManyToMany
     */
    /**
     * ilk olarak kurguyu belirleyin ve buna göre ilgili anoatsyonu ekletin.
     * *** CascadeType.ALL -> DB ye ekleme yapılırken belli kayıtlar birbirlerine ilişkilendirilir.
     *      bu nedenle ilişkilendirilelecek olan kaydın mutlaka bulunması gereklidir. Yani iş olmadan
     *      müşteir tanımı yapmak mümkün olmayacaktır.
     *      Burada alternatif olarak eğer bir bağlı yabancı anahtar mevcut değil ise, cascade ile 
     *      önce ilgili tabloda o kayıt oluşturulur sonra ana tabloya işlenen bilgiler ile kayıt 
     *      tamamlanır.
     */
    @OneToMany(cascade = CascadeType.ALL)
    /**
     * Aşağıda özlleştirilen bilgiler olmasa da olur. ancak biz oluşacak bo cross tablonun 
     * özelliklerini değiştirmek istiyorsak aşağıdaki gibi paraketre geçebiliriz.
     */
    @JoinTable(name = "tblmusteri_islistesi",
               joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "is_id")
            )
    List<Is> islistesi;
    
}
