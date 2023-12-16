package learn.springBoot.contactapi.ContactService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
//import java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import learn.springBoot.contactapi.domain.Contact;
import learn.springBoot.contactapi.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepo contactRepo;

    public Page<Contact> getAllContacts(int page, int size) {
        return contactRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Contact getContact(String id) {
        return contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public void deleteContact(String id) {
        Contact contact = getContact(id);
        contactRepo.deleteById(contact.getId());
    }

    public String uploadPhoto(String id, MultipartFile file) {
        Contact contact = getContact(id);
        String photoUrl = photoFunction.apply(id, file);
        contact.setPhotoUrl(photoUrl);
        contactRepo.save(contact);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".") + 1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) -> {
        try {
            Path fileStoregeLocation = Paths.get("").toAbsolutePath().normalize();
            if(!Files.exists(fileStoregeLocation)) { Files.createDirectories(fileStoregeLocation); }
            Files.copy(image.getInputStream(), fileStoregeLocation.resolve(id + fileExtension.apply(image.getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save image");
        }
        return id;
    };
}
