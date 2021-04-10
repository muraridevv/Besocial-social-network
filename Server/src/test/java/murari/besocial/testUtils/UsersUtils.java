package murari.besocial.testUtils;

import org.springframework.security.core.userdetails.UserDetails;

import murari.besocial.domain.entities.User;
import murari.besocial.domain.entities.UserRole;
import murari.besocial.domain.models.bindingModels.UserRegisterBindingModel;
import murari.besocial.domain.models.bindingModels.UserUpdateBindingModel;
import murari.besocial.domain.models.serviceModels.UserServiceModel;
import murari.besocial.domain.models.viewModels.UserCreateViewModel;
import murari.besocial.domain.models.viewModels.UserDetailsViewModel;
import murari.besocial.domain.models.viewModels.UserEditViewModel;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UsersUtils {
    public static User createUser() {
        return new User() {{
            setId("1");
            setPassword("1111");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
            setProfilePicUrl("profilePic");
            setBackgroundImageUrl("backgroundPic");
            setOnline(false);
        }};
    }

    public static List<User> getUsers(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> new User() {{
                    setId(String.valueOf(index + 1));
                    setPassword("1111");
                    setFirstName("Pesho " + index);
                    setLastName("Peshov " + index);
                    setUsername("pesho " + index);
                    setEmail("pesho " + index + " @abv.bg");
                    setCity("Sofia");
                    setAddress("Vasil Levski 1");
                    setProfilePicUrl("profilePic " + index);
                    setBackgroundImageUrl("backgroundPic " + index);
                    setOnline(false);
                }})
                .collect(Collectors.toList());
    }

    public static List<UserServiceModel> getUserServiceModels(int count, UserRole role) {
        LocalDateTime time = LocalDateTime.now();

        return IntStream.range(0, count)
                .mapToObj(index -> new UserServiceModel() {{
                    setId(String.valueOf(index + 1));
                    setPassword("1111");
                    setFirstName("Pesho " + index);
                    setLastName("Peshov " + index);
                    setUsername("pesho " + index);
                    setEmail("pesho " + index + " @abv.bg");
                    setCity("Sofia");
                    setAddress("Vasil Levski 1");
                    setProfilePicUrl("profilePic " + index);
                    setBackgroundImageUrl("backgroundPic " + index);
                    setAuthorities(new HashSet<>(Arrays.asList(role)));
                    setOnline(false);
                }})
                .collect(Collectors.toList());
    }

    public static UserRegisterBindingModel getUserRegisterBindingModel() {
        return new UserRegisterBindingModel() {{
            setPassword("1111");
            setConfirmPassword("1111");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
            setProfilePicUrl("profilePic");
            setBackgroundImageUrl("backgroundPic");
        }};
    }

    public static UserCreateViewModel getUserCreateViewModel() {
        return new UserCreateViewModel() {{
            setId("1");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
        }};
    }

    public static UserDetailsViewModel getUserDetailsViewModel(UserRole role) {
        return new UserDetailsViewModel() {{
            setId("1");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
            setProfilePicUrl("profilePic");
            setBackgroundImageUrl("backgroundPic");
            setAuthorities(new HashSet<>(Arrays.asList(role)));
        }};
    }

    public static UserEditViewModel getUserEditViewModel() {
        return new UserEditViewModel() {{
            setId("1");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
            setProfilePicUrl("profilePic");
            setBackgroundImageUrl("backgroundPic");
        }};
    }

    public static UserUpdateBindingModel getUserUpdateBindingModel() {
        return new UserUpdateBindingModel() {{
            setId("1");
            setFirstName("Pesho");
            setLastName("Peshov");
            setUsername("pesho");
            setEmail("pesho@abv.bg");
            setCity("Sofia");
            setAddress("Vasil Levski 1");
            setProfilePicUrl("profilePic");
            setBackgroundImageUrl("backgroundPic");
        }};
    }
}

