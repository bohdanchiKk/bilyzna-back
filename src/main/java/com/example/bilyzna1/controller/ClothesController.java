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
    @PostMapping
    public List<Clothes> findWithFilter(@PathVariable Type type,
                                        @PathVariable String additionaltype,
                                        @PathVariable String size,
                                        @PathVariable String brand){
        return clothesService.findWithFilter(type,additionaltype,size,brand);
    }
//    @GetMapping("/admin/bra/{id}")
//    public Optional<Bra> findById(@PathVariable Long id)
//    {return braService.findById(id);
//    }
//    @PostMapping("/admin/bra")
//    public ResponseEntity<Bra> uploadBra(@RequestBody Bra bra){
//        braService.add(bra);
//        return ResponseEntity.ok(bra);
//    }
//    @PostMapping("/admin/bra/{id}")
//    public String updateBra(@PathVariable Long id,@RequestBody Bra bra){
//        braService.update(id,bra);
//        return "updated";
//    }
//    @DeleteMapping("/admin/bra/{id}")
//    public void deleteBra(@PathVariable Long id){
//        braService.delete(id);
//    }
//    @GetMapping("/bra/new")
//    public ResponseEntity<List<Bra>> findNew(){
//        return braService.findNew();
//    }
//    @GetMapping("/bra/cheap")
//    public ResponseEntity<List<Bra>> findCheap(){
//        return braService.findCheap();
//    }
//    @GetMapping("/bra/exp")
//    public ResponseEntity<List<Bra>> findExp(){
//        return braService.findExp();
//    }
//    @GetMapping("/bra/filter")
//    public ResponseEntity<List<Bra>> findFilter(@PathVariable String brand, @PathVariable String type, @PathVariable String size){
//        return braService.findWithFilters(brand,type,size);
//    }
}
