package com.example.bilyzna1.controller;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.entity.SearchItems;
import com.example.bilyzna1.repository.SearchItemsRepository;
import com.example.bilyzna1.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    /** ADMIN PANEL */

    @GetMapping("/admin/t/{type}")
    public List<Clothes> findByAll(@PathVariable Type type)
    {
        return clothesService.findByType(type);
    }
    @PostMapping("/admin/add")
    public ResponseEntity<Clothes> add(@RequestBody Clothes clothes){
        clothesService.add(clothes);
        if(!alreadyExist(clothes.getName())){
            SearchItems searchItem = new SearchItems();
            searchItem.setName(clothes.getName());
            searchItem.setImage(clothes.getImage1());
            searchItemsRepository.save(searchItem);
            return ResponseEntity.ok(clothes);
        }
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
        var clothes = clothesService.findAllSpecific(type);
       return new ArrayList<>(clothes.stream()
               .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
               .values());

    }
    @GetMapping("/article/{article}")
    public List<String> findByArticle(@PathVariable String article)
    {
        var clothes = clothesService.findByArticle(article);
        List<String> sizes = new ArrayList<>();
        for(Clothes c : clothes){
            sizes.add(c.getSize());
        }
        return sizes;
    }

    @GetMapping("/newest")
    public List<Clothes> findBNewest()
    {
        var clothes = clothesService.findNewest();
        return clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .sorted((c1, c2) -> c2.getCreatedOn().compareTo(c1.getCreatedOn()))
                .collect(Collectors.toList());

    }

    @GetMapping("/{type}/cheap")
    public List<Clothes> findCheap(@PathVariable Type type){
        var clothes =  clothesService.findCheap(type);
        return clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Clothes::getPrice))
                .collect(Collectors.toList());


    }
    @GetMapping("/{type}/exp")
    public List<Clothes> findExp(@PathVariable Type type){
        var clothes = clothesService.findExp(type);
        return clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .sorted((c1, c2) -> c2.getPrice()-c1.getPrice())
                .collect(Collectors.toList());

    }
    @GetMapping("/{type}/new")
    public List<Clothes> findNew(@PathVariable Type type){
        var clothes =  clothesService.findNew(type);
        return clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .sorted((c1, c2) -> c2.getCreatedOn().compareTo(c1.getCreatedOn()))
                .collect(Collectors.toList());

    }

    @GetMapping("/FindByTypeAndBrand")
    public List<Clothes> findByTypeAndBrand(@RequestParam Type type,
            @RequestParam String brand){
        var clothes =  clothesService.findByTypeAndBrand(type,brand);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());
    }
    @GetMapping("/FindByTypeAndSize")
    public List<Clothes> findTypeAndSize(@RequestParam Type type,
                                     @RequestParam String size){
        var clothes = clothesService.findByTypeAndSize(type,size);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());

    }


    @GetMapping("/FindByTypeAndAdditionalType")
    public List<Clothes> findTypeAndAdditionalType(@RequestParam Type type,
                                         @RequestParam String additionaltype){
        var clothes =  clothesService.findByTypeAndAdditionalType(type,additionaltype);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());
    }
    @GetMapping("/FindByTypeAndBrandAndSize")
    public List<Clothes> findTypeAndBrandAndSize(@RequestParam Type type,
                                                   @RequestParam String brand,
                                                   @RequestParam String size){
        var clothes = clothesService.findByTypeAndBrandAndSize(type,brand,size);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());

    }
    @GetMapping("/FindByTypeAndBrandAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                 @RequestParam String brand,
                                                 @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        var clothes =  clothesService.findByTypeAndBrandAndSizeAndAdditionalType(type,brand,size,additionaltype);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());

    }
    @GetMapping("/FindByTypeAndBrandAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String brand,
                                                                    @RequestParam String additionaltype){
        var clothes = clothesService.findByTypeAndBrandAndAdditionalType(type,brand,additionaltype);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());

    }

    @GetMapping("/FindByTypeAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        var clothes = clothesService.findByTypeAndSizeAndAdditionalType(type,size,additionaltype);
        return new ArrayList<>(clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e -> e, (existing, replacement) -> existing))
                .values());
//        var newclother = clothes.stream()
//                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
//                .values()
//                .stream()
//                .collect(Collectors.toList());
    }


}
