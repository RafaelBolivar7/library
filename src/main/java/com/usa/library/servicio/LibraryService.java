package com.usa.library.servicio;


import com.usa.library.modelo.Library;
import com.usa.library.repositorio.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll(){
        return libraryRepository.getAll();
    }

    public Optional<Library> getLibrary(int libraryId) {
        return libraryRepository.getLibrary(libraryId);
    }

    public Library save(Library library){
        if(library.getId()==null){
            return libraryRepository.save(library);
        }else{
            Optional<Library>e= libraryRepository.getLibrary(library.getId());
            if(e.isEmpty()){
                return libraryRepository.save(library);
            }else{
                return library;
            }
        }
    }

    public Library update(Library library){
        if(library.getId()!=null){
            Optional<Library> e= libraryRepository.getLibrary(library.getId());
            if(!e.isEmpty()){
                if(library.getName()!=null){
                    e.get().setName(library.getName());
                }
                if(library.getTarget()!=null){
                    e.get().setTarget(library.getTarget());
                }
                if(library.getCapacity()!=null){
                    e.get().setCapacity(library.getCapacity());
                }
                if(library.getDescription()!=null){
                    e.get().setDescription(library.getDescription());
                }
                if(library.getCategory()!=null){
                    e.get().setCategory(library.getCategory());
                }
                libraryRepository.save(e.get());
                return e.get();
            }else{
                return library;
            }
        }else{
            return library;
        }
    }
    public boolean deleteLibrary(int id){
        Boolean d = getLibrary(id).map(library -> {
            libraryRepository.delete(library);
            return true;
        }).orElse(false);
        return d;
    }

}
