package blackjack.model;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNotEmpty(name);
    }

    private void checkNotEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름을 잘못 입력하셨습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
