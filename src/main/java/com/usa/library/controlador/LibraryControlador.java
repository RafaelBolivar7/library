package com.usa.library.controlador;

import com.usa.library.modelo.Library;
import com.usa.library.servicio.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Lib")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibraryControlador {
    @Autowired
    private LibraryService libraryService;
    @GetMapping("/all")
    public List<Library> getLibrarys(){
        return libraryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibrary(@PathVariable("id") int libraryId) {
        return libraryService.getLibrary(libraryId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library library) {
        return libraryService.save(library);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Library update(@RequestBody Library library) {
        return libraryService.update(library);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return libraryService.deleteLibrary(id);
    }

}
