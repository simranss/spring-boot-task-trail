package com.sharai.tasktrail.playground;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NoteRequest(@NotBlank @Size(max = 100) String title, @Size(max = 1000) String content) {
}
