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
    @PostMapping("/admin/{type}/{id}")
    public ResponseEntity<Optional<Clothes>> update(@PathVariable Long id,@RequestBody Clothes clothes,@PathVariable Type type){
        clothesService.update(id,clothes);
        return ResponseEntity.ok(clothesService.findById(id));
    }
    @DeleteMapping("/admin/{type}/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@PathVariable Type type){
        clothesService.deleteById(id);
        return ResponseEntity.ok("kanae!");
    }
    @GetMapping("/{type}/cheap")
    public ResponseEntity<String> findCheap(@PathVariable Type type){
        return (ResponseEntity<String>) clothesService.findCheap(type);
    }
    @GetMapping("/{type}/exp")
    public ResponseEntity<List<Clothes>> findExp(@PathVariable Type type){
        return (ResponseEntity<List<Clothes>>) clothesService.findExp(type);
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
