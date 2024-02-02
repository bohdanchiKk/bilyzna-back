package com.example.bilyzna1.controller;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.entity.Image;
import com.example.bilyzna1.entity.SearchItems;
import com.example.bilyzna1.entity.Size;
import com.example.bilyzna1.repository.SearchItemsRepository;
import com.example.bilyzna1.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class ClothesController {
    private ClothesService clothesService;
    private SearchItemsRepository searchItemsRepository;
    @Autowired
    public ClothesController(ClothesService clothesService,SearchItemsRepository searchItemsRepository)
    {
        this.clothesService = clothesService;
        this.searchItemsRepository = searchItemsRepository;
    }
    @GetMapping("/c/c")
    public void createClothes(){
        Random random = new Random();
        for(int i = 0; i<100; i++){
            Clothes clothes = new Clothes();
            clothes.setName(String.valueOf(random.nextInt(10000)));
            clothes.setBrand(String.valueOf(random.nextInt(10000)));
            clothes.setArticle(String.valueOf(random.nextInt(10000)));
            clothes.setAmount(String.valueOf(random.nextInt(10000)));
            clothes.setPrice((random.nextInt(10000)));
            clothes.setType(Type.bra);
            List<Image> imageList = new ArrayList<>();
            List<Size> sizeList = new ArrayList<>();
            for(int j =0; j<30; j++){
                Size size = new Size();
                size.setSize("M");
                size.setClothes(clothes);
                sizeList.add(size);
                Image image = new Image();
                image.setLink("sdfklasjdfkajsdfklasjdfklasjdfklasdf");
                image.setClothes(clothes);
                imageList.add(image);
            }
            clothes.setSize(sizeList);
            clothes.setDescription("asdfgklasdjfkncmvbnjkalsdfkasjdfklajsdfkjaskdlcxmnvm,ncxvbm,nxcvjsadkfl");
            clothes.setImages(imageList);
            clothesService.add(clothes);
        }
    }

    /** ADMIN PANEL */

    @GetMapping("/admin/t/{type}")
    public List<Clothes> findByAll(@PathVariable Type type)
    {
        return clothesService.findByType(type);
    }
    @PostMapping("/admin/add")
    public ResponseEntity<Clothes> add(@RequestBody Clothes clothes){
        var images = clothes.getImages();
        images.stream().forEach(n->n.setClothes(clothes));
        clothesService.add(clothes);
//        if(!alreadyExist(clothes.getName())){
//            SearchItems searchItem = new SearchItems();
//            searchItem.setName(clothes.getName());
//            searchItem.setImage(clothes.getImage1());
//            searchItemsRepository.save(searchItem);
//            return ResponseEntity.ok(clothes);
//        }
        return ResponseEntity.ok(clothes);
    }
    public boolean alreadyExist(String name){
        return searchItemsRepository.findByName(name) != null;
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<Optional<Clothes>> getById(@PathVariable Long id){
        return ResponseEntity.ok(clothesService.findById(id));
    }

    @PostMapping("/admin/{id}")
    public ResponseEntity<Optional<Clothes>> update(@PathVariable Long id,@RequestBody Clothes clothes){
        clothesService.update(id,clothes);
        return ResponseEntity.ok(clothesService.findById(id));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> update(@PathVariable Long id){
        clothesService.deleteById(id);
        return ResponseEntity.ok("kanae!");
    }
    /** SEARCH BAR */
    @PostMapping("/")
    public ResponseEntity<Optional<List<SearchItems>>> searchTop5ByFirstLetters(@RequestParam String word){
       var foundClothes = searchItemsRepository.findByWord(word);
        return ResponseEntity.ok(Optional.ofNullable(foundClothes));
    }

    /** SORTINGS */

    @GetMapping("/{type}")
    public List<Clothes> findAllSpecific(@PathVariable Type type)
    {
        return clothesService.findAllSpecific(type);
    }


    @GetMapping("/newest")
    public List<Clothes> findBNewest()
    {
        var clothes = clothesService.findNewest();
        return clothes
                .stream()
                .sorted((c1, c2) -> c2.getCreatedOn().compareTo(c1.getCreatedOn()))
                .collect(Collectors.toList());

    }

    @GetMapping("/{type}/cheap")
    public List<Clothes> findCheap(@PathVariable Type type){
        var clothes =  clothesService.findCheap(type);
        return clothes
                .stream()
                .sorted(Comparator.comparingInt(Clothes::getPrice))
                .collect(Collectors.toList());
    }
    @GetMapping("/{type}/exp")
    public List<Clothes> findExp(@PathVariable Type type){
        var clothes = clothesService.findExp(type);
        return clothes
                .stream()
                .sorted((c1, c2) -> c2.getPrice()-c1.getPrice())
                .collect(Collectors.toList());

    }
    @GetMapping("/{type}/new")
    public List<Clothes> findNew(@PathVariable Type type){
        var clothes =  clothesService.findNew(type);
        return clothes.stream()
                .sorted((c1, c2) -> c2.getCreatedOn().compareTo(c1.getCreatedOn()))
                .collect(Collectors.toList());
    }

    @GetMapping("/FindByTypeAndBrand")
    public List<Clothes> findByTypeAndBrand(@RequestParam Type type,
            @RequestParam String brand){
        return  clothesService.findByTypeAndBrand(type,brand);

    }
    @GetMapping("/FindByTypeAndSize")
    public List<Clothes> findTypeAndSize(@RequestParam Type type,
                                     @RequestParam Size size){
        return clothesService.findByTypeAndSize(type,size);
    }


    @GetMapping("/FindByTypeAndAdditionalType")
    public List<Clothes> findTypeAndAdditionalType(@RequestParam Type type,
                                         @RequestParam String additionaltype){
        return  clothesService.findByTypeAndAdditionalType(type,additionaltype);

    }
//    @GetMapping("/FindByTypeAndBrandAndSize")
//    public List<Clothes> findTypeAndBrandAndSize(@RequestParam Type type,
//                                                   @RequestParam String brand,
//                                                   @RequestParam String size){
//        return clothesService.findByTypeAndBrandAndSize(type,brand,size);
//    }
//    @GetMapping("/FindByTypeAndBrandAndSizeAndAdditionalType")
//    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
//                                                 @RequestParam String brand,
//                                                 @RequestParam String size,
//                                                                    @RequestParam String additionaltype){
//        return clothesService.findByTypeAndBrandAndSizeAndAdditionalType(type,brand,size,additionaltype);
//
//
//    }
    @GetMapping("/FindByTypeAndBrandAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String brand,
                                                                    @RequestParam String additionaltype){
        return clothesService.findByTypeAndBrandAndAdditionalType(type,brand,additionaltype);
    }

//    @GetMapping("/FindByTypeAndSizeAndAdditionalType")
//    public List<Clothes> findByTypeAndSizeAndAdditionalType(@RequestParam Type type,
//                                                                    @RequestParam String size,
//                                                                    @RequestParam String additionaltype){
//        return clothesService.findByTypeAndSizeAndAdditionalType(type,size,additionaltype);
//
//        }
    @GetMapping("/id/{id}")
    public Optional<Clothes> findOne(@PathVariable Long id) {
        return clothesService.findById(id);
    }
//        var newclother = clothes.stream()
//                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
//                .values()
//                .stream()
//                .collect(Collectors.toList());
    }
