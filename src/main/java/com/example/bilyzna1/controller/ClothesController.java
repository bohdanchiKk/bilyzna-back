package com.example.bilyzna1.controller;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return clothesService.findAllSpecific(type);
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
        return clothesService.findCheap(type);
    }
    @GetMapping("/{type}/exp")
    public List<Clothes> findExp(@PathVariable Type type){
        return  clothesService.findExp(type);
    }
    @GetMapping("/{type}/new")
    public List<Clothes> findNew(@PathVariable Type type){
        return  clothesService.findNew(type);
    }

    @GetMapping("/FindByTypeAndBrand")
    public List<Clothes> findByTypeAndBrand(@RequestParam Type type,
            @RequestParam String brand){
        return clothesService.findByTypeAndBrand(type,brand);
    }
    @GetMapping("/FindByTypeAndSize")
    public List<Clothes> findTypeAndSize(@RequestParam Type type,
                                     @RequestParam String size){
        return clothesService.findByTypeAndSize(type,size);
    }
    @GetMapping("/FindByTypeAndAdditionalType")
    public List<Clothes> findTypeAndAdditionalType(@RequestParam Type type,
                                         @RequestParam String additionaltype){
        return clothesService.findByTypeAndAdditionalType(type,additionaltype);
    }
    @GetMapping("/FindByTypeAndBrandAndSize")
    public List<Clothes> findTypeAndBrandAndSize(@RequestParam Type type,
                                                   @RequestParam String brand,
                                                   @RequestParam String size){
        return clothesService.findByTypeAndBrandAndSize(type,brand,size);
    }
    @GetMapping("/FindByTypeAndBrandAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                 @RequestParam String brand,
                                                 @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        return clothesService.findByTypeAndBrandAndSizeAndAdditionalType(type,brand,size,additionaltype);
    }
    @GetMapping("/FindByTypeAndBrandAndAdditionalType")
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String brand,
                                                                    @RequestParam String additionaltype){
        return clothesService.findByTypeAndBrandAndAdditionalType(type,brand,additionaltype);
    }
    @GetMapping("/FindByTypeAndSizeAndAdditionalType")
    public List<Clothes> findByTypeAndSizeAndAdditionalType(@RequestParam Type type,
                                                                    @RequestParam String size,
                                                                    @RequestParam String additionaltype){
        return clothesService.findByTypeAndSizeAndAdditionalType(type,size,additionaltype);
    }


}
