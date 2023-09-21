package com.example.bilyzna1.controller;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class ClothesController {
    private ClothesService clothesService;
    @Autowired
    public ClothesController(ClothesService clothesService)
    {
        this.clothesService = clothesService;
    }
    @GetMapping("/{type}")
    public List<Clothes> findAllSpecific(@PathVariable Type type)
    {
        var clothes = clothesService.findAllSpecific(type);
       var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
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
    @GetMapping("/admin/t/{type}")
    public List<Clothes> findByAll(@PathVariable Type type)
    {
        return clothesService.findByType(type);
    }
    @GetMapping("/newest")
    public List<Clothes> findBNewest()
    {
        var clothes = clothesService.findNewest();
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @PostMapping("/admin/add")
    public ResponseEntity<Clothes> add(@RequestBody Clothes clothes){
        clothesService.add(clothes);
        return ResponseEntity.ok(clothes);
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
    @GetMapping("/{type}/cheap")
    public List<Clothes> findCheap(@PathVariable Type type){
        var clothes =  clothesService.findCheap(type);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;

    }
    @GetMapping("/{type}/exp")
    public List<Clothes> findExp(@PathVariable Type type){
        var clothes = clothesService.findExp(type);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;

    }
    @GetMapping("/{type}/new")
    public List<Clothes> findNew(@PathVariable Type type){
        var clothes =  clothesService.findNew(type);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }

    @GetMapping("/FindByTypeAndBrand")
    public List<Clothes> findByTypeAndBrand(@RequestParam Type type,
            @RequestParam String brand){
        var clothes =  clothesService.findByTypeAndBrand(type,brand);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @GetMapping("/FindByTypeAndSize")
    public List<Clothes> findTypeAndSize(@RequestParam Type type,
                                     @RequestParam String size){
        var clothes = clothesService.findByTypeAndSize(type,size);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
//    sdsdsd.
    //sdsdsd
    @GetMapping("/FindByTypeAndAdditionalType")
    public List<Clothes> findTypeAndAdditionalType(@RequestParam Type type,
                                         @RequestParam String additionaltype){
        var clothes =  clothesService.findByTypeAndAdditionalType(type,additionaltype);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @GetMapping("/FindByTypeAndBrandAndSize")
    public List<Clothes> findTypeAndBrandAndSize(@RequestParam Type type,
                                                   @RequestParam String brand,
                                                   @RequestParam String size){
        var clothes = clothesService.findByTypeAndBrandAndSize(type,brand,size);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @GetMapping("/FindByTypeAndBrandAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                 @RequestParam String brand,
                                                 @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        var clothes =  clothesService.findByTypeAndBrandAndSizeAndAdditionalType(type,brand,size,additionaltype);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @GetMapping("/FindByTypeAndBrandAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String brand,
                                                                    @RequestParam String additionaltype){
        var clothes = clothesService.findByTypeAndBrandAndAdditionalType(type,brand,additionaltype);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }
    @GetMapping("/FindByTypeAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        var clothes = clothesService.findByTypeAndSizeAndAdditionalType(type,size,additionaltype);
        var newclother = clothes.stream()
                .collect(Collectors.toMap(Clothes::getImage1, e->e,(existing,replacement) ->existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return newclother;
    }


}
