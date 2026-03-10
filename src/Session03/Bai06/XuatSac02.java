package Session03.Bai06;

import java.util.List;
import java.util.stream.Collectors;

public class XuatSac02 {
    public static void main(String[] args) {
        List<Post> posts = List.of(
                new Post(List.of("java", "backend")),
                new Post(List.of("python", "data"))
        );

        List<String> allTags = posts.stream().flatMap(post -> post.getTags().stream()).collect(Collectors.toList());
        System.out.println(allTags);
    }
}
